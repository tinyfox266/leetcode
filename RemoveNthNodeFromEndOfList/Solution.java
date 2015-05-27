public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        int len = length(head);
        if (n > len)
            return head;
        if (n==len) {
            head = head.next;
            return head;
        }
        ListNode pre=head, cur=head.next;
        for (int i=1; i < len-n;i++) {
            pre=cur;
            cur=cur.next;
        }
        pre.next = cur.next;

        return head;
    }

    public int length(ListNode head) {
        int len=0;
        ListNode n = head;
        while (n!=null) {
            n = n.next;
            len++;
        }
        return len;
    }
}
