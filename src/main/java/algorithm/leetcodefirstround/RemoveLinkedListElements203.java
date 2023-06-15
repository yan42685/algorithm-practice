package algorithm.leetcodefirstround;

/**
 * @author alexyan
 * @date 1/6/2020 09:15
 */
public class RemoveLinkedListElements203 {
    private class ListNode {
        int val;
        ListNode next;
        public  ListNode(int val) {
            this.val = val;
        }
    }

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
