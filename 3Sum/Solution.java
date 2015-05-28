public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        if (nums.length == 0)
            return solutions;
        for (int i=0; i < nums.length; i++) {
            if (i > 0) {
                if (nums[i] == nums[i-1])
                    continue;
            }
            for (int j=i+1, k=nums.length-1;j < k;) {
                if (nums[i]+ nums[j] + nums[k] == 0) {
                    List<Integer> solution = new ArrayList<Integer>();
                    solution.add(nums[i]);
                    solution.add(nums[j]);
                    solution.add(nums[k]);
                    if (!solutions.contains(solution))
                        solutions.add(solution);
                    j++;
                    k--;
                } else if (nums[i]+ nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return solutions;
    }
}
