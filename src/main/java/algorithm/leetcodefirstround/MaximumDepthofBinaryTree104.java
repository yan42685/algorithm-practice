package algorithm.leetcodefirstround;

import algorithm.common.TreeNode;

/**
 * @author alexyan
 * @date 1/4/2020 18:45
 */
public class MaximumDepthofBinaryTree104 {
    private int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
