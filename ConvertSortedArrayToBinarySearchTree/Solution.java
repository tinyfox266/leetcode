public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if (begin > end || begin < 0 || end > nums.length-1) {
            return null;
        }
        if (begin == end)
            return new TreeNode(nums[begin]);
        int mid = begin + (end-begin)/2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = sortedArrayToBST(nums, begin, mid-1);
        TreeNode right = sortedArrayToBST(nums, mid+1, end);
        root.left = left;
        root.right = right;

        return root;
    }
}
