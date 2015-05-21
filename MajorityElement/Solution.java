public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length==1)
            return nums[0];
            
        Arrays.sort(nums);
        int count=1;
        int max=0;
        for (int i=1; i < nums.length; i++) {
            while (i < nums.length && nums[i]==nums[i-1]) {
                count++;
                i++;
            }
            if (count > nums.length/2) {
                max = nums[i-1];
                return max;
            }
            count=1;
        }

        return max;
    }
}
