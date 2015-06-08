public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        
        ListNode slow=head, fast=head.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast)
                return true;
            if (fast != null) {
                fast = fast.next;
                if (slow == fast)
                    return true;
            }
        }
        
        return false;
    }
}
