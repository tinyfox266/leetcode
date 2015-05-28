public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int max_p=nums[0];
        int p=1;
        for (int i=0; i < nums.length; i++) {
            p = p * nums[i];
            max_p = Math.max(max_p, p);
            if (nums[i] == 0)
                p = 1;
        }
        p=1;
        for (int i=nums.length-1; i >=0 ;i--) {
            p = p * nums[i];
            max_p = Math.max(max_p, p);
            if (nums[i] == 0)
                p = 1;
        }

        return max_p;
    }
}
