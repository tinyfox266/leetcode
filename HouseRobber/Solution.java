public class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 0)
            return 0;
        int [] robbedHouse = new int[nums.length+1];
        robbedHouse[1] = nums[0];
        robbedHouse[0] = 0;
        for (int i=1; i < nums.length; i++) {
            robbedHouse[i+1] = Math.max(robbedHouse[i-1]+nums[i], robbedHouse[i]);
        }

        return robbedHouse[nums.length];

    }
}
