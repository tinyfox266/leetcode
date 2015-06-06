public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int sum=0;
        int start=0;
        int end=0;
        int index=0;
        int minCount=Integer.MAX_VALUE;
        int count=0;
        while(index < nums.length) {
            sum += nums[index];
            if (sum >= s) {
                while (start <= index && sum >= s) {
                    minCount=Math.min(minCount, index-start+1);
                    sum -= nums[start];
                    start++;


                }
            }
            index++;
        }

        return minCount<Integer.MAX_VALUE?minCount:0;
    }
}
