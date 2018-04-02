package util.LocalCache;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenlei
 * @since 2017 - 07 - 01 13:07
 */
class LRUMap<T> extends LinkedHashMap<String, SoftReference<T>> {

    private static final long serialVersionUID = -7076355612133906912L;

    /** The maximum size of the cache. */
    private int maxCacheSize;

    /* lock for map */
    private final Lock lock = new ReentrantLock();

//    /**
//     * 默认构造函数，LRUMap的大小为Integer.MAX_VALUE
//     */
//    public LRUMap() {
//        super();
//        maxCacheSize = Integer.MAX_VALUE;
//    }

    /**
     * Constructs a new, empty cache with the specified maximum size.
     */
    LRUMap(int size) {
        super(size + 1, 1f, true);
        maxCacheSize = size;
    }

    /**
     * 让LinkHashMap支持LRU，如果Map的大小超过了预定值，则返回true，LinkedHashMap自身实现返回
     * fasle，即永远不删除元素
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, SoftReference<T>> eldest) {
        return (size() > maxCacheSize);
    }

    T addEntry(String key, T entry) {
        try {
            SoftReference<T> sr_entry = new SoftReference<>(entry);
            // add entry to hashmap
            lock.lock();
            put(key, sr_entry);
        }
        finally {
            lock.unlock();
        }
        return entry;
    }

    T getEntry(String key) {
        SoftReference<T> sr_entry;
        try {
            lock.lock();
            if ((sr_entry = get(key)) == null)
                return null;
            // if soft reference is null then the entry has been
            // garbage collected and so the key should be removed also.
            if (sr_entry.get() == null) {
                remove(key);
                return null;
            }
        }
        finally {
            lock.unlock();
        }
        return sr_entry.get();
    }

    @Override
    public SoftReference<T> remove(Object key) {
        try {
            lock.lock();
            return super.remove(key);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public synchronized void clear() {
        super.clear();
    }

}
