public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode newHead,n,n1=l1,n2=l2;
        if (l1.val <= l2.val) {
            newHead = l1;
            n1 = n1.next;
        }
        else {
            newHead = l2;
            n2 = n2.next;
        }
        n = newHead;

        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                n.next = n1;
                n1 = n1.next;
            } else {
                n.next = n2;
                n2 = n2.next;
            }
            n = n.next;
        }
        if (n1 == null) {
            while (n2 != null) {
                n.next = n2;
                n2 = n2.next;
                n = n.next;
            }
        } else if (n2 == null) {
            while (n1 != null) {
                n.next = n1;
                n1 = n1.next;
                n = n.next;

            }
        }

        return newHead;
    }
}
