public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new LinkedList<List<Integer>>();
        if (candidates == null || candidates.length == 0)
            return combinations;

        Arrays.sort(candidates);
        combinations.addAll(combinationSum2_(candidates, target, candidates.length - 1));

        return combinations;
    }

    public Set<List<Integer>> combinationSum2_(int[] candidates, int target, int i) {
        Set<List<Integer>> combinations = new HashSet<List<Integer>>();
        if (target == 0) {
            combinations.add(new LinkedList<Integer>());
        }
        if (i < 0)
            return combinations;
        if (target < 0)
            return combinations;
        
        Set<List<Integer>> combinations1 = combinationSum2_(candidates, target, i-1);
        Set<List<Integer>> combinations2 = combinationSum2_(candidates, target-candidates[i], i-1);
        combinations.addAll(combinations1);
        for (List<Integer> l: combinations2) {
            l.add(candidates[i]);
            combinations.add(l);
        }

        return combinations;
    }
}
