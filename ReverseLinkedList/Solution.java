/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode prev = head;
        ListNode newHead = head;
        newHead = newHead.next;
        ListNode headNext;
        while (newHead != null) {
            headNext = newHead.next;
            newHead.next = prev;
            prev = newHead;
            newHead = headNext;
        }
        head.next = null;
        return prev;
    }
}
