public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int max = nums[0];
        int pre = nums[0];
        int cur = nums[0];
        for (int i=1; i < nums.length; i++) {
            if (pre  <  0) {
                pre = nums[i];
            } else {
                pre = pre + nums[i];
            }
            max = Math.max(max, pre);
        }

        return max;
    }
}
