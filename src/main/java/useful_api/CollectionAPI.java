package useful_api;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionAPI {
    public static void main(String[] args) {
        // 不可变的空列表
        List<Integer> emptyList =  Collections.emptyList();
        Set<Object> emptySet = Collections.emptySet();
        Map<Object, Object> emptyMap = Collections.emptyMap();
    }
}
