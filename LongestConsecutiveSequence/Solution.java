public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Map<Integer, LinkNode> numMap = new HashMap<Integer, LinkNode>();
        for (int n:nums) {
            LinkNode left = numMap.get(n-1);
            LinkNode right = numMap.get(n+1);
            LinkNode cur = new LinkNode();

            if (left != null && right != null) {
                left.next = cur;
                cur.next = right;
            } else if (left == null && right != null) {
                cur.next = right;
            } else if (left != null && right == null) {
                left.next = cur;
            }
            numMap.put(n, cur);
        }

        int max=0;
        for (LinkNode node: numMap.values()) {
            if (node.tag == 0) {
                int curCount = 0;
                while (node != null) {
                    curCount++;
                    node.tag = 1;
                    node = node.next;
                }
                max = Math.max(max, curCount);
            }
        }

        return max;

    }

    class LinkNode {
        public int tag=0;
        public LinkNode next=null;

    }
}
