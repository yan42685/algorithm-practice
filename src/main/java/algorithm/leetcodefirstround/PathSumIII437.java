package algorithm.leetcodefirstround;

import algorithm.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alexyan
 * @date 1/7/2020 07:44
 */
public class PathSumIII437 {
    /**
     * 两层DFS O(n^2)
     */
    private int result = 0;

    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return this.result;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        test(root, target);
        dfs(root.left, target);
        dfs(root.right, target);
    }

    private void test(TreeNode cur, int target) {
        if (cur == null) {
            return;
        }
        this.result += cur.val == target ? 1 : 0;
        test(cur.left, target - cur.val);
        test(cur.right, target - cur.val);
    }

    public int pathSum2(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return dfs(root, 0, preSum, sum);
    }

    private int dfs(TreeNode root, int currSum, Map<Integer, Integer> preSum, int target) {
        if (root == null) {
            return 0;
        }
        currSum += root.val;
        int result = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        result += dfs(root.left, currSum, preSum, target) + dfs(root.right, currSum, preSum, target);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return result;
    }

}
