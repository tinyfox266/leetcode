public class Solution {
    public int singleNumber(int[] nums) {
        int xrSum=0;
        for (int i=0; i < nums.length; i++) {
            xrSum ^= nums[i];
        }

        return xrSum;
    }
}
