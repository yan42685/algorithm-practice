package algorithm.leetcodefirstround;

import algorithm.basic.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alexyan
 * @date 1/7/2020 17:30
 * 因为只有一遍循环，所以比最高票答案快, 时间空间均超过100%
 */
public class FindModeinBinarySearchTree501 {
    private int currValue;
    private int tmpCount = 0;
    private int maxCount = 0;
    private List<Integer> result = new LinkedList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] models = new int[result.size()];
        for (int i = 0; i < models.length; i++) {
            models[i] = result.get(i);
        }
        return models;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        handleValue(root.val);
        dfs(root.right);
    }

    private void handleValue(int x) {
        tmpCount++;
        if (currValue != x) {
            currValue = x;
            tmpCount = 1;
        }
        if (tmpCount > maxCount) {
            maxCount = tmpCount;
            result.clear();
            result.add(x);
        } else if (tmpCount == maxCount) {
            result.add(x);
        }
    }
}

