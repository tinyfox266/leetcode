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
        // assume that p and q exists in tree root.
        if (root == null || p == null || q == null)
            return null;

        if (p.val == root.val || q.val == root.val)
            return root;

        if (p.val < root.val && q.val > root.val)
            return root;

        if (p.val > root.val && q.val < root.val)
            return root;

        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p ,q);

        return lowestCommonAncestor(root.right, p, q);


    }
}

