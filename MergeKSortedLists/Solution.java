/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsHelper(lists, 0, lists.length-1);
    }

    public ListNode mergeKListsHelper(ListNode[] lists, int i, int j) {
        if (i > j) {
            return null;
        } else if (i == j) {
            return lists[i];
        } else if (j-i == 1) {
            return mergeLists(lists[i], lists[j]);
        }

        ListNode l1 = mergeKListsHelper(lists, i, i+(j-i+1)/2);
        ListNode l2 = mergeKListsHelper(lists, i+(j-i+1)/2+1, j);

        return mergeLists(l1, l2);


    }
    
    public ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummyNode = new ListNode(0);
        ListNode node=dummyNode;
        ListNode n1=l1, n2=l2;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                node.next=n1;
                node = node.next;
                n1 = n1.next;
            } else {
                node.next=n2;
                node = node.next;
                n2 = n2.next;
            }
        }

        while (n1 != null) {
            node.next = n1;
            node = node.next;
            n1 = n1.next;
        }

        while (n2 != null) {
            node.next = n2;
            node = node.next;
            n2 = n2.next;
        }

        return dummyNode.next;
    }
}
