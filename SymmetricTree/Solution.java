public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isSubtreeSymmetric(root.left, root.right);
    }

    public boolean isSubtreeSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;

        if (t1 == null && t2 != null ||
                t1 != null & t2 == null)
            return false;

        if (t1.val != t2.val)
            return false;

        return isSubtreeSymmetric(t1.left, t2.right)
                && isSubtreeSymmetric(t1.right, t2.left);

    }
}
