public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] indexes = {-1,-1};
        if (nums == null || nums.length < 2 )
            return indexes;

        Map<Integer,List<Integer>> originalIndex = new HashMap<Integer, List<Integer>>();
        for (int i=0; i < nums.length; i++) {
            List<Integer> l = new LinkedList<Integer>();
            if (originalIndex.get(nums[i]) == null)
                originalIndex.put(nums[i], l);
            originalIndex.get(nums[i]).add(i);
        }
        Arrays.sort(nums);
        indexes[0] = 0;
        indexes[1] = nums.length-1;
        for (int i=0,j=nums.length-1; i < j;) {
            if (nums[i] + nums[j] == target) {
                List<Integer> l = originalIndex.get(nums[i]);
                if (l.size() == 1) {
                    indexes[0] = Math.min(originalIndex.get(nums[i]).get(0)+1,originalIndex.get(nums[j]).get(0)+1);
                    indexes[1] = Math.max(originalIndex.get(nums[i]).get(0)+1,originalIndex.get(nums[j]).get(0)+1);
                } else {
                    indexes[0] = Math.min(originalIndex.get(nums[i]).get(0)+1, originalIndex.get(nums[j]).get(1)+1);
                    indexes[1] = Math.max(originalIndex.get(nums[i]).get(0)+1, originalIndex.get(nums[j]).get(1)+1);
                }

                return indexes;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }

        }

        return indexes;
    }
}
