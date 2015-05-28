public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums.length < 4)
            return results;
        Arrays.sort(nums);
        for (int i=0; i < nums.length; i++) {
            for (int j=i+1; j < nums.length; j++) {
                for(int k=j+1,h=nums.length-1; k < h;) {
                    if (nums[i]+nums[j]+nums[k]+nums[h] == target) {
                        List<Integer> result = new ArrayList<Integer>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        result.add(nums[h]);
                        Collections.sort(result);
                        if (!results.contains(result))
                            results.add(result);
                        k++;
                        h--;
                    } else if (nums[i]+nums[j]+nums[k]+nums[h] < target) {
                        k++;
                    } else {
                        h--;
                    }
                }
            }
        }
        return results;
    }
}
