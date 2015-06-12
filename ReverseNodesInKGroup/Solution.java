public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        if (k <= 1)
            return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastEnd = dummyHead;
        ListNode pre = dummyHead;
        ListNode cur = head;
        ListNode reverseHead = pre;
        ListNode reverseTail = dummyHead;
        while (cur != null) {

            for (int i=0; i < k; i++) {
                if (cur == null)
                    return dummyHead.next;
                cur = cur.next;
            }
            pre = reverseTail.next;
            ListNode tmp = pre.next;
            for (int i=1; i < k; i++) {
                ListNode next = tmp.next;
                tmp.next = pre;
                pre = tmp;
                tmp = next;
            }
            ListNode tail = reverseTail.next;
            reverseTail.next = pre;
            reverseTail = tail;
            reverseTail.next = cur;
        }


        return dummyHead.next;
    }
}
