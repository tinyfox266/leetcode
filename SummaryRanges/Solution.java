public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        if (nums == null || nums.length == 0)
            return res;

        int start=nums[0], end=nums[0];
        for (int i=1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]+1) {
                end++;
            } else {
                if (start == end) {
                    res.add(start+"");
                } else {
                    res.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if (start == end) {
            res.add(start+"");
        } else {
            res.add(start + "->" + end);
        }
        return res;

    }
}
