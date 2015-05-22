# Rotate Array Submission Details
## Error
Runtime Error Message:  Line 7: java.lang.ArrayIndexOutOfBoundsException: 2

Last executed input:    [1,2], 0

## Submitted Code
    public class Solution {
        public void rotate(int[] nums, int k) {
            int [] rotatedNum = new int[nums.length];
            int i=0;
            int steps = k%(nums.length);
            for (; i<nums.length-1-steps; i++) {
                rotatedNum[i]=nums[nums.length-steps+i];
            }
            for (; i < nums.length; i++) {
                rotatedNum[i]=nums[i-steps];
            }
            for (int j=0; j < nums.length; j++) {
                nums[j] = rotatedNum[j];
            }
        }
    }
    
----------------------------------------------
----------------------------------------------

## Error 
Runtime Error Message:  Line 12: java.lang.ArrayIndexOutOfBoundsException: -1

Last executed input:    [1,2], 1

## Submission Code 
    public class Solution {
        public void rotate(int[] nums, int k) {
            if (k==0)
                return;
            int [] rotatedNum = new int[nums.length];
            int i=0;
            int steps = k%(nums.length);
            for (; i<nums.length-1-steps; i++) {
                rotatedNum[i]=nums[nums.length-steps+i];
            }
            for (; i < nums.length; i++) {
                rotatedNum[i]=nums[i-steps];
            }
            for (int j=0; j < nums.length; j++) {
                nums[j] = rotatedNum[j];
            }
        }
    }

