package util.LocalCache;

/**
 * @author chenlei
 * @since 2017 - 07 - 01 13:10
 */
public class CacheObject  {

    private Object object;
    private long timestamp;

    public CacheObject(Object object, long timestamp) {
        this.object = object;
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
