package algorithm.leetcodefirstround;

import java.util.Arrays;

/**
 * @author: alexyan
 * @date: 10/13/2019 09:51
 * @description:
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix1(String[] strs) {
        /*
         * @Description: 排序法
         * @Return:
         */
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        Arrays.sort(strs);
        char[] a = strs[0].toCharArray();
        char[] b = strs[strs.length - 1].toCharArray();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i])
                ans.append(a[i]);
            else break;
        }
        return ans.toString();
    }


    public String longestCommonPrefix2(String[] strs) {
        /*
         * @Description: 依赖int indexOf(String str) 这个函数
         * @Return:
         */
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }
}
