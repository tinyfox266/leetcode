public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        if (nums.length == 1)
            return;

        int idx = find(nums);

        reverse(nums, idx+1, nums.length-1);

    }

    public int find(int [] nums) {
        for (int i=nums.length-2; i >= 0; i--) {
            for (int j=nums.length-1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    return i;
                }
            }
        }

        return -1;
    }

    public void swap (int [] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void reverse(int nums[], int b, int e) {
        while (b < e) {
            swap(nums, b, e);
            b++;
            e--;
        }
    }
}
