package algorithm.basic;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author alexyan
 * @date 1/4/2020 19:25
 */
public class TreeTravelsal {

    public void preOrderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + ", ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public void preOrderIterative(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                System.out.print(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop().right;
        }
    }

    /**
     * 先序morris
     */
    public List<Integer> preorderMorris(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode prev = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right != curr) {
                    prev.right = curr;
                    result.add(curr.val);
                    curr = curr.left;
                } else {
                    curr = curr.right;
                    prev.right = null;
                }
            }
        }
        return result;
    }


    public void inOrderRecursive(TreeNode root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.print(root.val);
            inOrderRecursive(root.right);
        }
    }

    public void inOrderIterative(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + ", ");
            curr = curr.right;
        }
    }


    /**
     * Morris算法在中序遍历的应用, 空间复杂度 O(1)
     * 中序遍历的本质：要想访问root节点，必须先访问其leftTree。
     * 但如果不借助stack，在访问了leftTree之后，又如何能再次访问root呢？
     * 答: 二叉树的线索化
     */
    public void inorderMorris(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null) {
            // 左子树不存在时，访问+进入右节点
            if (curr.left == null) {
                System.out.println(curr.val);
                curr = curr.right;
                // 左子树存在，寻找前驱节点。注意寻找前驱节点时，会不断深入右子树。不加判断时，若前驱节点的右子树已指向自己，会引起死循环
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                // 前驱节点未访问过，存放后继节点
                if (prev.right != curr) {
                    prev.right = curr;
                    curr = curr.left;
                    // 前驱节点已访问过，恢复树结构
                } else {
                    // 确定访问过左子树后，访问当前节点
                    System.out.println(curr.val);
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
    }


    public void postOrderRecursive(TreeNode root) {
        if (root != null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.print(root.val + ", ");
        }
    }


    /**
     * 普通迭代后序遍历
     */
    public void postOrderIterative1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode last = null;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            // 右子树非空或者右子树没有遍历完
            if (curr.right != null && curr.right != last) {
                curr = curr.right;
            } else {
                System.out.print(curr.val + ", ");
                stack.pop();
                last = curr;
                curr = null;
            }
        }
    }

    /**
     * dequeue迭代后序遍历, 只能做简单的处理, 好像涉及到回溯的迭代解法就是后序遍历
     */
    public void postOrderIterative2(TreeNode root) {
        Deque<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                result.offerFirst(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop().right;
        }
    }

    /**
     * morris后序遍历过于复杂，这里不考虑, 面试考到了就算是倒霉好吧
     */

    /**
     * 层次遍历 BFS
     */
    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                System.out.println(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            ++level;
        }
    }
}
