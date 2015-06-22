public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        radixSort(nums, 16, 8);

        int maxGap = 0;
        for (int i=1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i]-nums[i-1]);
        }


        return maxGap;
    }

    public void radixSort(int [] nums, int radix, int d) {
        int [] tmp = new int[nums.length];
        int [] buckets = new int[radix];
        int rate=1;

        for (int i=0; i < d; i++) {
            System.arraycopy(nums, 0, tmp , 0, nums.length);
            Arrays.fill(buckets, 0);

            for (int n: tmp) {
                int subKey = (n/rate) % radix;
                buckets[subKey]++;
            }

            for (int j=1; j < radix; j++) {
                buckets[j] = buckets[j] + buckets[j-1];
            }

            for (int j=tmp.length-1; j >= 0; j--) {
                int subKey = (tmp[j]/rate) % radix;
                nums[--buckets[subKey]] = tmp[j];
            }

            rate = rate*radix;
        }
    }
}
