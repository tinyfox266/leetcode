public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        ListNode n1=head, n2=head.next;
        ListNode t1;
        while (n1 != null && n1.next != null) {
            n2 = n1.next;
            t1 = n2.next;
            pre.next = n2;
            n2.next = n1;
            pre = n1;
            n1 = t1;
        }
        if ( n1 != null)
            pre.next = n1;
        else
            pre.next = null;

        return dummyHead.next;
    }
}
