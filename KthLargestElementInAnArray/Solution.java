public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0)
            return 0;

        bubbleSort(nums);
        return nums[nums.length-k];

    }

    public void bubbleSort(int [] nums) {
        for (int i=0; i < nums.length; i++) {
            for (int j=0; j < nums.length-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    int t = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = t;
                }
            }
        }
    }
}
