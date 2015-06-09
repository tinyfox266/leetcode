public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        TreeLinkNode pre = null;
        int count=1;
        while (!q.isEmpty()) {
            TreeLinkNode n = q.poll();
            count--;
            if (pre != null) {
                pre.next = n;
                pre = n;
            } else {
                pre = n;
            }
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);

            if (count == 0) {
                pre = null;
                count = q.size();
                n.next = null;
            }
        }
    }
}
