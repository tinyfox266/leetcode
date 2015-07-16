public class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null)
            return;

        ListNode pre = node;
        node = node.next;
        while(node.next != null) {
            pre.val = node.val;
            pre = node;
            node = node.next;
        }
        pre.val = node.val;
        pre.next = null;
    }
}
