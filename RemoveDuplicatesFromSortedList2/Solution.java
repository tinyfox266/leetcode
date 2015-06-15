public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur=head.next;
        ListNode pre=head;
        ListNode prepre= dummyHead;
        int flag = 0;
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
                cur = cur.next;
                flag = 1;
            } else {
                if (flag == 1) {
                    prepre.next = cur;
                    flag = 0;
                } else {
                    prepre = pre;
                }
                pre = cur;
                cur = cur.next;
            }
        }

        if (flag == 1) {
            prepre.next = cur;
        }

        return dummyHead.next;
    }
}
