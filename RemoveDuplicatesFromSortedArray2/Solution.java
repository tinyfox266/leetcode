public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Map<Integer, Integer> occurNum = new HashMap<Integer, Integer>();
        int cur=0;
        for (int i=0; i < nums.length; i++) {
            int n = nums[i];
            if (occurNum.get(n) == null) {
                nums[cur] = nums[i];
                cur++;
                occurNum.put(n,1);
            } else if (occurNum.get(n) == 1) {
                nums[cur] = nums[i];
                cur++;
                occurNum.put(n,2);
            }
        }

        return cur;
    }
}
