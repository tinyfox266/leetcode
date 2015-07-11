/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        HashMap<RandomListNode,List<RandomListNode>> pointsTo =
                new HashMap<RandomListNode, List<RandomListNode>>();
        HashMap<RandomListNode, RandomListNode> map =
                new HashMap<RandomListNode, RandomListNode>();

        RandomListNode node = head;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode newPre = dummyHead;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            newPre.next = newNode;
            newPre = newNode;
            if (map.get(node) == null) {
                map.put(node, newNode);
            }

            if (pointsTo.get(node) != null) {
                for (RandomListNode n: pointsTo.get(node)) {
                    map.get(n).random = newNode;
                }
            }

            RandomListNode random = node.random;
            if (map.get(random) != null) {
                newNode.random = map.get(random);
            } else {
                if (pointsTo.get(random) == null) {
                    List<RandomListNode> pointByNodes = new LinkedList<RandomListNode>();
                    pointByNodes.add(node);
                    pointsTo.put(random, pointByNodes);
                } else {
                    pointsTo.get(random).add(node);
                }
            }

            node = node.next;

        }


        return dummyHead.next;
    }
}

