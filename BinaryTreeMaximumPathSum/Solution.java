public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxToRootPathSum(root);
        return max;
    }

    public int maxToRootPathSum(TreeNode root) {
        if (root == null)
            return 0;

        int sum=root.val;
        int leftMax = maxToRootPathSum(root.left);
        int rightMax = maxToRootPathSum(root.right);
        int leftMaxPlusRoot = root.val;
        int rightMaxPlusRoot = root.val;
        if (leftMax > 0) {
            sum += leftMax;
            leftMaxPlusRoot += leftMax;
        }
        if (rightMax > 0) {
            sum += rightMax;
            rightMaxPlusRoot += rightMax;
        }

        max = Math.max(max, sum);


        return Math.max(leftMaxPlusRoot, rightMaxPlusRoot);
    }
}
