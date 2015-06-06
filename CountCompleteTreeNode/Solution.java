public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int llh = leftDepth(root.left);
        int lrh = rightDepth(root.left);
        int rlh = leftDepth(root.right);
        int rrh = rightDepth(root.right);
        if (llh == 0)
            return 1;
        if (rlh == 0)
            return 2;
        if (llh == rrh) {
            return (int)(Math.pow(2,llh+1)-1);
        } else if (llh == lrh) {
            int lcount = (int)(Math.pow(2,llh)-1);
            int rcount = countNodes(root.right);
            return lcount + rcount + 1;
        } else {
            int lcount = countNodes(root.left);
            int rcount = (int)(Math.pow(2,llh-1))-1;
            return lcount + rcount + 1;
        }
    }

    public int leftDepth(TreeNode root) {
        if (root == null)
            return 0;
        return (leftDepth(root.left) + 1);
    }

    public int rightDepth(TreeNode root) {
        if (root == null)
            return 0;
        return (rightDepth(root.right) + 1);

    }

    public int countNodes1(TreeNode root) {
        if (root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
