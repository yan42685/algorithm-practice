package algorithm.leetcodefirstround;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: alexyan
 * @date: 10/12/2019 13:43
 * @description:
 */
public class FirstUniqueCharacterInAString387 {
    public int firstUniqChar1(String s) {
        /*
         * @Description: 遍历两边
         * @Return:
         */
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        /*
         * @Description:
         * @Return:
         */
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                map.remove(ch);
            } else {
                map.put(ch, i);
                set.add(ch);
            }
        }
        return map.size() == 0 ? -1 : map.values().iterator().next();
    }

}
