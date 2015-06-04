public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0)
            return Integer.MIN_VALUE;
        if (nums.length == 1)
            return nums[0];

        return findIntervalMin(nums, 0, nums.length-1);
    }

    private int findIntervalMin(int [] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left/2 + right/2;
        if (nums[mid] <= nums[right]) {
            if (mid == right)
                mid--;
            return findIntervalMin(nums, left, mid);
        } else {
            if (mid == left)
                mid++;
            return findIntervalMin(nums, mid, right);

        }
    }
}
