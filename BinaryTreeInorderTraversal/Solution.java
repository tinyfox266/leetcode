public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();

        if (root == null)
            return res;

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode n = root;
        while (n != null) {
            s.push(n);
            n = n.left;
        }

        while (!s.isEmpty()) {
            n = s.pop();
            res.add(n.val);
            n = n.right;
            while (n != null) {
                s.push(n);
                n = n.left;
            }

        }

        return res;
    }
}
