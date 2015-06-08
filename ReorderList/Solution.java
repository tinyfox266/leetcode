public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode cur;
        ListNode slow = head, fast=head.next;
        ListNode firstTail = null;
        while (fast != null) {
            firstTail = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        firstTail.next = null;
        ListNode secondHalf = reverse(slow);
        head= merge(head, secondHalf);

    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while( cur!= null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
        ListNode n1=h1, n2=h2;
        ListNode dummyHead = new ListNode(-1);
        ListNode n = dummyHead;
        while (n1 != null && n2 != null) {
            n.next = n1;
            n1 = n1.next;
            n = n.next;

            n.next = n2;
            n2 = n2.next;
            n = n.next;
        }

        while (n1 != null) {
            n.next = n1;
            n1 = n1.next;
            n = n.next;
        }

        while (n2 != null) {
            n.next = n2;
            n2 = n2.next;
            n = n.next;
        }

        return dummyHead.next;
    }
}
