# Majority Element
## Error
Runtime Error 

Runtime Error Message:  Line 7: java.lang.ArrayIndexOutOfBoundsException: 2

Last executed input:    [2,2]

## Submitted Code
    public class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            int count=1;
            int max=0;
            for (int i=1; i < nums.length; i++) {
                while (nums[i]==nums[i-1] && i < nums.length) {
                    count++;
                    i++;
                }
                if (count >= nums.length/2) {
                    max = nums[i-1];
                    return 0;
                }
                count=1;
            }

            return max;
        }
    }

-------------------------------------------------------------------------
-------------------------------------------------------------------------

# Error
Wrong Answer

Input:  [1]

Output: 0

Expected:   1

## Submitted Code
    public class Solution {
        public int majorityElement(int[] nums) {
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
