public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] {-1,-1};
        int [] range = {-1,-1};
        int low=0, high=nums.length-1;
        while (low <= high) {
            int mid = low+(high-low)/2;
            if (target == nums[mid]) {
                range[0] = mid;
                range[1] = mid;
                for (int i=mid; i >= low && nums[i]==target; i--)
                    range[0]=i;
                for (int i=mid; i <= high && nums[i]==target; i++)
                    range[1]=i;

                return range;
            } else if (target < nums[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return range;
    }
}
