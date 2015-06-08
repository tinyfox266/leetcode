public class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        TreeNode DummyRoot= new TreeNode(0);
        TreeNode cur = DummyRoot;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            TreeNode left = n.left;
            cur.left = null;
            cur.right = n;
            cur = n;
            if (n.right != null) {
                s.push(n.right);
            }
            while (left != null) {
                cur.left = null;
                cur.right = left;
                cur = left;
                if (left.right != null)
                    s.push(left.right);
                left = left.left;
            }
        }

    }
}
