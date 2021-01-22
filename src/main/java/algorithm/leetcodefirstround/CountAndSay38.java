package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 10/12/2019 22:33
 * @description: 总结: 初始化，处理， 更新（复原）
 */
public class CountAndSay38 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1, count = 1; j <= s.length(); j++) {
                if (j == s.length() || s.charAt(j - 1) != s.charAt(j)) {
                    sb.append(count);
                    sb.append(s.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            s = sb.toString();
        }
        return s;
    }
}
