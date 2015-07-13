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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // assume p and q exists in root
        if (root == null)
            return null;

        if (p == q)
            return p;

        if (root == p)
            return p;

        if (root == q)
            return q;

        boolean pInLeft = inTree(root.left, p);
        boolean qInLeft = inTree(root.left, q);

        if (pInLeft && qInLeft)
            return lowestCommonAncestor(root.left, p, q);

        if (pInLeft != qInLeft)
            return root;

        return lowestCommonAncestor(root.right, p, q);


    }


    boolean inTree(TreeNode root, TreeNode n) {
        if (root == null)
            return false;
        if (root == n)
            return true;

        return inTree(root.left, n) || inTree(root.right, n);
    }
}

