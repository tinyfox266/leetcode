public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode index = head;
        ListNode pre = head;
        ListNode n = head.next;

        while (n != null) {
            if (pre.val !=  n.val) {
                index.next = n;
                index = index.next;
            }
            pre = n;
            n = n.next;
        }
        index.next = null;
        return head;
    }
}
