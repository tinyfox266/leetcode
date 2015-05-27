public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob12(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                rob12(Arrays.copyOfRange(nums, 1, nums.length )));
    }

    public int rob12(int [] nums) {
        if (nums.length <= 0)
            return 0;

        if (nums.length == 1)
            return nums[0];
        int [] maxStolen = new int[nums.length];
        maxStolen[0] = nums[0];
        maxStolen[1] = Math.max(maxStolen[0], nums[1]);
        if (nums.length == 2)
            return maxStolen[1];
        for (int i=2; i < nums.length; i++) {
            maxStolen[i] = Math.max(maxStolen[i-1], maxStolen[i-2]+nums[i]);
        }
        return maxStolen[nums.length-1];
    }
}
