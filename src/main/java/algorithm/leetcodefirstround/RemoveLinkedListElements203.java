package algorithm.leetcodefirstround;

/**
 * @author alexyan
 * @date 1/6/2020 09:15
 */
public class RemoveLinkedListElements203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }
}
