package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 10/13/2019 12:16
 * @description:
 */
public class RemoveNthNodeFromEndOfList19 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = newHead;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}
