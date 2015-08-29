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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new LinkedList<String>();
        }
        
        if (root.left == null && root.right == null) {
            List<String> l = new LinkedList<String>();
            l.add(Integer.toString(root.val));
            return l;
        }
        
        List<String> lr=null, ll=null;
        List<String> l = new LinkedList<String>();

        if (root.left != null) {
            ll = binaryTreePaths(root.left);
            for (String sl: ll) {
                String s = root.val + "->" + sl;
                l.add(s);
            }
        }
        
        if (root.right != null) {
            lr = binaryTreePaths(root.right);
            for (String sr: lr) {
                String s = root.val + "->" + sr;
                l.add(s);
            }
        }
        
        return l;
    }
}

