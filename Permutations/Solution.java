public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;

        res = permute(nums, 0);

        return res;


    }

    public List<List<Integer>> permute(int[] nums, int start) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if ((start >= nums.length)) {
            res.add(new LinkedList<Integer>());
            return res;
        }

        List<List<Integer>> resPrime = permute(nums, start+1);
        for (List<Integer> l: resPrime) {
            for (int i=0; i < l.size()+1; i++) {
                List<Integer> tmp = new LinkedList<Integer>(l);
                tmp.add(i, nums[start]);
                res.add(tmp);
            }
        }

        return res;
    }
}
