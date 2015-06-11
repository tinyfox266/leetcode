public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        if (nums.length == 1)
            return true;

        boolean [] canJumpArray = new boolean[nums.length];
        canJumpArray[nums.length-1] = true;
        for (int i=nums.length-2; i >= 0; i--) {
            int count=nums[i];
            boolean succ = false;
            if (nums[i] <= nums[i+1]+1 && canJumpArray[i+1] == false) {
                canJumpArray[i] = false;
                continue;
            } else if (nums[i] > nums[i+1] && canJumpArray[i+1] == true) {
                canJumpArray[i] = true;
                continue;
            }
            for (int j=count; j >= 1; j--) {
                if (i+j < nums.length && canJumpArray[i+j]) {
                    succ = true;
                    break;
                }
            }
            canJumpArray[i] = succ;
        }

        return canJumpArray[0];
    }
}
