public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slower = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null) {
            slower = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        slower.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        while (left != null) {
            tail.next = left;
            left = left.next;
            tail = tail.next;
        }
        while (right != null) {
            tail.next = right;
            right = right.next;
            tail = tail.next;
        }

        ListNode returnHead = dummyHead.next;
        dummyHead = null;
        return returnHead;
    }
}
