public class Solution {
     List<List<Integer>> rst= new LinkedList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> l = new LinkedList<List<Integer>>();
        LinkedList<Integer> sol = new LinkedList<Integer>();
        List<Integer> set = new LinkedList<Integer>();
        if (nums.length == 0)
            return l;
        for (int i=0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        permute(sol,set);
        return rst;

    }

    public void permute(LinkedList<Integer> sol, List<Integer> set) {
        if (set.isEmpty()) {
            rst.add(sol);
            return;
        }
        HashSet<Integer> used = new HashSet<Integer>();
        for (int i=0; i < set.size(); i++) {
            if (used.contains(set.get(i)))
                continue;  
            used.add(set.get(i));
            LinkedList<Integer> solC = (LinkedList<Integer>) sol.clone();
            solC.add(set.get(i));
            int v = set.remove(i);
            permute(solC, set);
            set.add(i,v);
        }
    }
}
