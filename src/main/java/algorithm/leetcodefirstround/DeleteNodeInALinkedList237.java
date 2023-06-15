package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 10/13/2019 11:32
 * @description:
 */
public class DeleteNodeInALinkedList237 {
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
