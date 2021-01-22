package algorithm.leetcodefirstround;

import java.util.HashMap;
import java.util.Map;

public class T291 {
    private Map<Character, String> map = new HashMap<>();

    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        char letter = pattern.charAt(0);
        for (int len = 1; len <= str.length() - pattern.length() + 1; len++) {
            String step = str.substring(0, len);
            String mapStr = map.get(letter);
            // 如果是初次遇到pattern中的letter并且该子串没有被其他letter映射; 或者该subStr符合pattern中的letter
            if ((mapStr == null && !map.containsValue(step)) || (mapStr != null && mapStr.equals(step))) {
                map.put(letter, step);
                if (wordPatternMatch(pattern.substring(1), str.substring(len))) {
                    return true;
                } else if (mapStr == null) {
                    map.remove(letter);
                }
            }
        }
        return false;
    }
}
