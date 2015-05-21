/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode item = head;
        ListNode newHead=head;
        ListNode prev=null;
        while (item != null) {
            if (item.val == val) {
                if (item == newHead) {
                    newHead = newHead.next;
                    item = item.next;
                } else if (item.next != null) {
                    prev.next = item.next;
                    item = item.next;
                } else if (item.next==null){
                    prev.next = null;
                    item = item.next;
                }
            } else {
                prev = item;
                item = item.next;

            }
        }

        return newHead;
    }
}
