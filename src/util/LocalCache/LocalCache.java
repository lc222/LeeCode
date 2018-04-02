package util.LocalCache;

import util.StringUtils;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenlei
 * @since 2017 - 07 - 01 13:13
 */
public class LocalCache {

    private final int size;

    private int concurrencyLevel;

    /**
     * 本地缓存最大容量
     */
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 本地缓存支持最大的分区数
     */
    private static final int MAX_SEGMENTS = 1 << 16; // slightly conservative

    /**
     * 本地缓存存储的LRUMap数组
     */
    private LRUMap<CacheObject>[] segments;

    /**
     * Mask value for indexing into segments. The upper bits of a key's hash
     * code are used to choose the segment.
     */
    private int segmentMask;

    /**
     * Shift value for indexing within segments.
     */
    private int segmentShift;

    /**
     * 计数器重置阀值
     */
    private static final int MAX_LOOKUP = 100000000;

    /**
     * 用于重置计数器的锁，防止多次重置计数器
     */
    private final Lock lock = new ReentrantLock();

    /**
     * Number of requests made to lookup a cache entry.
     */
    private AtomicLong lookup = new AtomicLong(0);

    /**
     * Number of successful requests for cache entries.
     */
    private AtomicLong found = new AtomicLong(0);

    public LocalCache(int size) {
        this.size = size;
        this.concurrencyLevel = 16;
    }


    public CacheObject get(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        // 增加计数器
        lookup.incrementAndGet();

        // 如果必要重置计数器
        if (lookup.get() > MAX_LOOKUP) {
            if (lock.tryLock()) {
                try {
                    lookup.set(0);
                    found.set(0);
                } finally {
                    lock.unlock();
                }
            }
        }

        int hash = hash(key.hashCode());
        CacheObject ret = segmentFor(hash).getEntry(key);
        if (ret != null)
            found.incrementAndGet();
        return ret;
    }


    public void remove(String key) {
        if (StringUtils.isBlank(key)) {
            return;
        }
        int hash = hash(key.hashCode());
        segmentFor(hash).remove(key);
    }

    public void put(String key, CacheObject val) {
        if (StringUtils.isBlank(key) || val == null) {
            return;
        }
        int hash = hash(key.hashCode());
        segmentFor(hash).addEntry(key, val);
    }

    private synchronized void clearCache() {
        for (LRUMap<CacheObject> segment : segments) segment.clear();
    }

    public synchronized void reload() {
        clearCache();
        init();
    }

    /**
     * 本地缓存命中次数，在计数器RESET的时刻可能会出现0的命中率
     */
    public int getHitRate() {
        long query = lookup.get();
        return query == 0 ? 0 : (int) ((found.get() * 100) / query);
    }

    /**
     * 本地缓存访问次数，在计数器RESET时可能会出现0的查找次数
     */
    public long getCount() {
        return lookup.get();
    }

    public int size() {
        final LRUMap<CacheObject>[] segments = this.segments;
        long sum = 0;
        for (LRUMap<CacheObject> segment : segments) {
            sum += segment.size();
        }
        if (sum > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) sum;
    }


    /**
     * Returns the segment that should be used for key with given hash
     *
     * @param hash
     *            the hash code for the key
     * @return the segment
     */
    private LRUMap<CacheObject> segmentFor(int hash) {
        return segments[(hash >>> segmentShift) & segmentMask];
    }


    /* ---------------- Small Utilities -------------- */

    /**
     * Applies a supplemental hash function to a given hashCode, which defends
     * against poor quality hash functions. This is critical because
     * ConcurrentHashMap uses power-of-two length hash tables, that otherwise
     * encounter collisions for hashCodes that do not differ in lower or upper
     * bits.
     */
    private static int hash(int h) {
        // Spread bits to regularize both segment and index locations,
        // using variant of single-word Wang/Jenkins hash.
        h += (h << 15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h << 3);
        h ^= (h >>> 6);
        h += (h << 2) + (h << 14);
        return h ^ (h >>> 16);
    }

    @SuppressWarnings("unchecked")
    public void init() {
        int capacity = size;
        if (capacity < 0 || concurrencyLevel <= 0)
            throw new IllegalArgumentException();
        if (concurrencyLevel > MAX_SEGMENTS)
            concurrencyLevel = MAX_SEGMENTS;
        // Find power-of-two sizes best matching arguments
        int sshift = 0;
        int ssize = 1;
        while (ssize < concurrencyLevel) {
            ++sshift;
            ssize <<= 1;
        }
        segmentShift = 32 - sshift;
        segmentMask = ssize - 1;
        this.segments = new LRUMap[ssize];
        if (capacity > MAXIMUM_CAPACITY)
            capacity = MAXIMUM_CAPACITY;
        int c = capacity / ssize;
        if (c * ssize < capacity)
            ++c;
        int cap = 1;
        while (cap < c)
            cap <<= 1;
        cap >>= 1;
        for (int i = 0; i < this.segments.length; ++i)
            this.segments[i] = new LRUMap<>(cap);
    }

    public static void main(String[] args) throws Exception{
        LocalCache localCache = new LocalCache(2000000);
        localCache.init();
        localCache.put("test", new CacheObject("haaa", 1234L));
        localCache.put("testlili", new CacheObject("haaa", 1234L));
        System.out.println(localCache.get("test").getObject());
        System.out.println(localCache.size());
    }
}

