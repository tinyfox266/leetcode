public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Set visited = new HashSet();
        if (root == null)
            return result;

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        TreeNode n = null;
        while(!s.isEmpty() || n != null) {
            if (n == null) {
                n = s.pop();
            }
            if (n.right != null)
                s.push(n.right);
            result.add(n.val);
            n = n.left;
        }
        return result;

    }
}
