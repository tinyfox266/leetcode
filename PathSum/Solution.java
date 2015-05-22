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
    Queue<TreeNode> pathQueue = new LinkedList<TreeNode>();
    Queue<Integer> sumQueue = new LinkedList<Integer>();

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        pathQueue.add(root);
        sumQueue.add(root.val);
        while(!pathQueue.isEmpty()) {
            TreeNode n = pathQueue.remove();
            int v = sumQueue.remove();
            if (isLeaf(n) && v==sum)
                return true;
            TreeNode nLeft = n.left;
            if (nLeft != null) {
                pathQueue.add(nLeft);
                sumQueue.add(v+nLeft.val);
            }
            TreeNode nRight = n.right;
            if (nRight != null) {
                pathQueue.add(nRight);
                sumQueue.add(v+nRight.val);
            }

        }

        return false;
    }

    public boolean isLeaf(TreeNode n) {
        if (n==null)
            return true;
        if (n.left == null && n.right == null)
            return true;

        return false;
    }
}
