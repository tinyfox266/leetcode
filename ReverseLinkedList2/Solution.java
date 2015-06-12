public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;

        if ( m >= n)
            return head;

        if ( m <= 0)
            m = 1;
        int count=0;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode before = dummyHead;
        ListNode betweenLast = dummyHead;
        ListNode pre = dummyHead;
        ListNode cur = head;
        boolean startReverse = false;
        while (cur != null) {
            count ++;
            if (count == m) {
                startReverse = true;
                betweenLast = cur;
                pre = cur;
                cur = cur.next;
                continue;
            }
            if (!startReverse) {
                before = cur;
                pre = cur;
                cur = cur.next;
            } else {
                if (count <= n) {
                    ListNode next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                } else {
                    break;
                }
            }
        }
        betweenLast.next = cur;
        before.next = pre;
        return dummyHead.next;
    }
}
