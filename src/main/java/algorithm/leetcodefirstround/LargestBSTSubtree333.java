package algorithm.leetcodefirstround;

import algorithm.common.TreeNode;

public class LargestBSTSubtree333 {
    int result;

    public int solution(TreeNode root) {
        dfs(root);
        return result;
    }

    private class Tree {
        boolean isBST;
        int size;
        int min;
        int max;

        public Tree() {
            isBST = false;
            size = 0;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
    }

    public Tree dfs(TreeNode root) {
        Tree curr = new Tree();
        if (root == null) {
            curr.isBST = true;
            return curr;
        }
        Tree left = dfs(root.left);
        Tree right = dfs(root.right);
        if (left.isBST && right.isBST && left.max < root.val && root.val < right.min) {
            curr.isBST = true;
            curr.min = Math.min(root.val, left.min);
            curr.max = Math.max(root.val, right.max);
            curr.size = left.size + right.size + 1;
            result = Math.max(result, curr.size);
        }
        return curr;
    }
}
