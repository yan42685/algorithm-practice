package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 10/12/2019 14:20
 * @description:
 */
public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int count : alphabet) {
            if (count != 0)
                return false;
        }
        return true;
    }
}
