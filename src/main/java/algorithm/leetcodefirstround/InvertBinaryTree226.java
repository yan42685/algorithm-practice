package algorithm.leetcodefirstround;

import algorithm.basic.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author alexyan
 * @date 1/6/2020 09:44
 */
public class InvertBinaryTree226 {
    /**
     * DFS recursive 前序
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    /**
     * 前序DFS iterative
     */
    public TreeNode invertTree2(TreeNode root) {
        TreeNode cur = root;
        Deque<TreeNode> toVisit = new LinkedList<>();
        TreeNode tmp = null;
        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                toVisit.push(cur);
                cur = cur.left;
            }
            cur = toVisit.pop().right;
        }
        return root;
    }

}
