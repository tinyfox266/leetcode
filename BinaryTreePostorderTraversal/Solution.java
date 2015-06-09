public class Solution {
   public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null)
            return res;

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode n = root;
        TreeNode pre = null;
        while (n != null) {
            s.push(n);
            n = n.left;
        }
        while (!s.empty()) {
            n = s.peek();
            if (n.right == null || n.right == pre) {
                res.add(n.val);
                pre = s.pop();
            } else {
                n = n.right;
                while (n != null) {
                    s.push(n);
                    n = n.left;
                }
            }

        }
        
        return res;
    }
}
