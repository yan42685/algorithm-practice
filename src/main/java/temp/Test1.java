package temp;


import algorithm.common.Trie;
import utils.TimeUtils;

import java.util.HashMap;

public class Test1 {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Trie<Integer> trie = new Trie<>();
        for (int i = 0; i < 10000; i++) {
            map.put("abc" + String.valueOf(i), i);
            trie.insert("abc" + String.valueOf(i), i);
        }
//        testHashMap(map);
        testTrie(trie);
    }

    public static void testHashMap(HashMap<String, Integer> map) {
        TimeUtils.measureExecuteTime(100, () -> map.get("abc323"));
    }

    public static void testTrie(Trie<Integer> trie) {
        TimeUtils.measureExecuteTime(100, () -> trie.get("abc323"));
    }

}
