public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lessNode=dummyHead;
        ListNode n = head;
        ListNode pre=dummyHead;
        while (n != null) {
            if (n.val < x) {
                if (lessNode.next == n) {
                    lessNode = lessNode.next;
                    n = n.next;
                } else {
                    pre.next=n.next;
                    n.next = lessNode.next;
                    lessNode.next = n;
                    lessNode = lessNode.next;
                    n = pre.next;
                }
            } else {
                pre = n;
                n = n.next;
            }
        }

        return dummyHead.next;
    }
}
