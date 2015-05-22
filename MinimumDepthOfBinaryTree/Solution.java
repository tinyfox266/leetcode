/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (isLeaf(root))
            return 1;

        int leftMinDepth, rightMinDepth;
        if (root.left != null)
            leftMinDepth = minDepth(root.left);
        else
            leftMinDepth = Integer.MAX_VALUE;

        if (root.right != null)
            rightMinDepth = minDepth(root.right);
        else
        rightMinDepth = Integer.MAX_VALUE;

        return leftMinDepth <= rightMinDepth ? leftMinDepth+1 : rightMinDepth+1;

    }

    public boolean isLeaf(TreeNode n) {
        if (n==null)
            return true;
        if (n.left == null && n.right == null)
            return true;

        return false;
    }
}
