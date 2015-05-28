public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 2)
            return 0;

        Arrays.sort(nums);
        int ret = nums[0]+nums[1]+nums[2];
        int dist = Integer.MAX_VALUE;

        for (int i=0; i < nums.length; i++) {
            if (i > 0) {
                if (nums[i] == nums[i-1])
                    continue;
            }
            for (int j=i+1,k=nums.length-1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] == target)
                    return target;
                else if (nums[i] + nums[j] + nums[k] < target) {
                    if (Math.abs(target-nums[i]-nums[j]-nums[k]) < dist) {
                        ret = nums[i]+nums[j]+nums[k];
                        dist = Math.abs(target-ret);
                    }
                    j++;
                } else {
                    if (Math.abs(target-nums[i]-nums[j]-nums[k]) < dist) {
                        ret = nums[i]+nums[j]+nums[k];
                        dist = Math.abs(target-ret);
                    }
                    k--;
                }
            }
        }
        return ret;
    }
}
