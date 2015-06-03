public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int start=0, end=nums.length-1;
        int mid=start/2+end/2;
        while (start <= end) {
            mid=start+((end-start)/2);
            if ( target == nums[mid])
                return mid;
            else if (target < nums[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        if (target < nums[mid])
            return mid;
        else
            return mid+1;

    }
}
