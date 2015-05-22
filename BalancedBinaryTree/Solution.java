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
    class HeightBalancePair {

        int height;
        boolean isBalanced;

        public HeightBalancePair(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }

        public int getHeight(){
            return height;
        }

        public boolean isBalanced() {
            return isBalanced;
        }

    }

    public boolean isBalanced(TreeNode root) {
        return heightAndBalance(root).isBalanced;
    }

    public HeightBalancePair heightAndBalance(TreeNode root) {
        HeightBalancePair p;
        if (root == null) {
            p = new HeightBalancePair(0, true);
            return p;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        HeightBalancePair pLeft = heightAndBalance(left);
        if (!pLeft.isBalanced)
            return new HeightBalancePair(-1, false);
        HeightBalancePair pRight = heightAndBalance(right);
        if (!pRight.isBalanced)
            return new HeightBalancePair(-1, false);

        if (Math.abs(pLeft.getHeight()-pRight.getHeight()) <=1 )
            return new HeightBalancePair(Math.max(pLeft.getHeight(),pRight.getHeight())+1, true);
        else
            return new HeightBalancePair(-1, false);

    }
}
