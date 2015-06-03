public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int low=0, high=nums.length-1;
        while (low <= high) {
            int mid=low+(high-low)/2;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid]) {
                if (nums[low] < nums[mid]) {
                    if (target == nums[low]) {
                        return low;
                    } else if (target < nums[low]) {
                        low = mid+1;
                    } else {
                        high = mid-1;
                    }
                }
                else if (nums[low] == nums[mid]) {
                    low=mid+1;
                } else {
                    high = mid-1;
                }
            } else {
                if (nums[low] < nums[mid]) {
                    low = mid+1;
                }
                else if (nums[low] == nums[mid]) {
                    low=mid+1;
                } else {
                    if (target == nums[high]) {
                        return high;
                    } else if (target < nums[high]) {
                        low = mid+1;
                    } else {
                        high = mid-1;
                    }
                }
            }
        }

        return -1;
    }
}
