public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
            if (slow == fast)
                break;
        }
        
        if (fast == null)
            return null;
        
        ListNode n1 = head;
        ListNode n2 = fast;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        
        return n1;
    }
}
