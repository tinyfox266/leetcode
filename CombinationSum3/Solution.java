public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int [] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        List<Integer> path = new LinkedList<Integer>();
        doDFS(0, nums, k, n, path, ret);
        return ret;
    }

    public void doDFS(int start, int [] nums, int k, int n, List<Integer> path, List<List<Integer>> ret) {
        if (path.size() > k && n != 0)
            return;
        if (path.size() == k && n==0) {
            List<Integer> list = new LinkedList<Integer>(path);
            if (!ret.contains(list))
                ret.add(list);
        }
        for (int i=start; i < nums.length; i++) {
            path.add(nums[i]);
            doDFS(i + 1, nums, k, n - nums[i], path, ret);
            path.remove(path.size()-1);
        }
    }
}
