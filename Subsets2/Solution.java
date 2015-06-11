public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return subsets;

        Arrays.sort(nums);

        Set<List<Integer>> sets = subsetsWithDup_(nums, nums.length-1);
        subsets.addAll(sets);

        return subsets;
    }

    public Set<List<Integer>> subsetsWithDup_(int[] nums, int i) {
        Set<List<Integer>> sets = new HashSet<List<Integer>>();
        if (i < 0) {
            sets.add(new LinkedList<Integer>());
            return sets;
        }

        Set<List<Integer>> sets1 = subsetsWithDup_(nums, i - 1);
        for (List<Integer> l : sets1) {
            sets.add(new LinkedList<Integer>(l));
            l.add(nums[i]);
            sets.add(l);
        }

        return sets;

    }
}
