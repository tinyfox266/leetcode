public class Solution {
    public void rotate(int[] nums, int k) {
        if (k==0)
            return;
        int [] rotatedNum = new int[nums.length];
        int i=0;
        int steps = k%(nums.length);
        for (; i<steps; i++) {
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
