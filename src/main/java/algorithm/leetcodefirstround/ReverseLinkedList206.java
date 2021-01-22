package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 10/13/2019 13:57
 * @description:
 */
public class ReverseLinkedList206 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode reverseList1(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        /* recursive solution */
        return reverseList2(head, null);
    }

    private ListNode reverseList2(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseList2(next, head);
    }
}
