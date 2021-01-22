package algorithm.leetcodefirstround;

import algorithm.common.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal314 {
    private class Pair {
        int col;
        TreeNode node;

        public Pair(int column, TreeNode treeNode) {
            col = column;
            node = treeNode;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<Pair> queue = new LinkedList<>();
        Set<Integer> cols = new HashSet<>();
        int offset = 0;  // root列在result中的位置
        queue.offer(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int col = curr.col;
            TreeNode node = curr.node;
            // 如果是第一次访问该列
            if (!cols.contains(col)) {
                cols.add(col);
                List<Integer> list = new LinkedList<>();
                // 注意是大于等于..
                if (col >= 0) {
                    result.add(list);
                } else {
                    result.add(0, list);
                    ++offset;
                }
                cols.add(col);
            }
            result.get(col + offset).add(node.val);

            if (node.left != null) {
                queue.add(new Pair(col - 1, node.left));
            }
            if (curr.node.right != null) {
                queue.add(new Pair(col + 1, node.right));
            }
        }
        return result;
    }

}
