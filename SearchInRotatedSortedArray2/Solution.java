public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        int low=0, high=nums.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[low] == nums[mid]) {
                low++;
            } else if (nums[high] == nums[mid]) {
                high--;
            } else if (nums[low] > nums[mid]) {
                if (target < nums[mid]) {
                    high = mid-1;
                } else {
                    if (target <= nums[high])
                        low = mid+1;
                    else
                        high = mid-1;
                }
            } else if (nums[mid] > nums[high]) {
                if (target < nums[mid]) {
                    if (target < nums[low])
                        low = mid+1;
                    else
                        high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if (target < nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
        }

        return false;
    }
}
