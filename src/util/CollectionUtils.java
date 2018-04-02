package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenlei
 * @since 2017 - 06 - 05 10:50
 */
public class CollectionUtils {

    @SafeVarargs
    public static <T> List<T> asList(T ...args) {
        List<T> list = new ArrayList<T>();
        Collections.addAll(list, args);
        return list;
    }

}
