public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null)
            return new LinkedList<List<Integer>>();
        if (nums.length == 0) {
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            result.add(new LinkedList<Integer>());
            return result;
        }
        Arrays.sort(nums);
        return  subsets(nums, 0);

    }

    public List<List<Integer>> subsets(int[] nums, int start) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();


        if (start >= nums.length) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        List<List<Integer>> subResult = subsets(nums, start+1);
        result.addAll(subResult);
        for (List l:subResult) {
            List<Integer> foo = new LinkedList<Integer>(l);
            foo.add(0,nums[start]);
            result.add(foo);
        }



        return result;
    }
}
