/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;


        ListNode fast=head.next, slow=head, mid=null;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next; // make sure fast=slow*2 or fast=2*(slow-1)+1
            }
        }

        mid = slow.next;
        ListNode lastHalfReverse = reverse(mid);
        ListNode n2 = lastHalfReverse;
        ListNode n1 = head;
        while(n2 != null) {
            if (n1.val != n2.val)
                return false;
            n2 = n2.next;
            n1 = n1.next;
        }

        slow.next = reverse(lastHalfReverse);

        return true;



    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode cur=head, pre=null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

    }
}
