public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int redEnd = -1;
        int blueBegin = nums.length;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] != 0) {
                redEnd = i-1;
                break;
            }
        }

        for (int i=nums.length-1; i >= 0; i--) {
            if (nums[i] != 2) {
                blueBegin = i+1;
                break;
            }
        }

        for (int i=redEnd+1; i < blueBegin; i++) {
            if (nums[i] == 0) {
                redEnd++;
                int t = nums[redEnd];
                nums[redEnd] = nums[i];
                nums[i] = t;
            }
        }

        for (int i=blueBegin-1; i > redEnd; i--) {
            if (nums[i] == 2) {
                blueBegin--;
                int t = nums[blueBegin];
                nums[blueBegin] = nums[i];
                nums[i] = t;
            }
        }
    }
}
