public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 0;

        int curMax=0;
        int curRch=0;
        int ret=0;
        for (int i=0; i < nums.length; i++) {
            if (curRch < i) {
                ret++;
                curRch = curMax;
            }
            curMax = Math.max(curMax, nums[i]+i);
        }
        
        return ret;
    }
}
