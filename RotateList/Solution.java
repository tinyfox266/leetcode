/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int len=0;
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            len++;
            pre = cur;
            cur = cur.next;
        }

        k = k%len;

        if (k == 0) {
            return head;
        }
        
        
        cur = head;
        ListNode last2 = pre;

        for (int i=0; i < len-k-1 && cur != null; i++) {
            cur = cur.next;
        }


        if (cur == null)
            return head;


        ListNode newHead = cur.next;
        cur.next = null;
        last2.next = head;


        return newHead;

    }
}
