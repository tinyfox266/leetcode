public class BSTIterator {
    Stack<TreeNode> s = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (s.isEmpty())
            return 0;
        TreeNode n = s.pop();
        int v = n.val;
        if (n.right != null) {
            n = n.right;
            while (n != null) {
                s.push(n);
                n = n.left;
            }

        }

        return v;

    }
}
