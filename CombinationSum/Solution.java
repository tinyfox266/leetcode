public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new LinkedList<List<Integer>>();
        if (candidates == null || candidates.length == 0)
            return combinations;
        Arrays.sort(candidates);
        combinations.addAll(combinationSum_(candidates, target, candidates.length-1));
        return combinations;
    }

    public Set<List<Integer>> combinationSum_(int[] candidates, int target, int i) {
        Set<List<Integer>> combinations = new HashSet<List<Integer>>();
        if (target < 0)
            return combinations;
        if (target == 0) {
            combinations.add(new LinkedList<Integer>());
            return combinations;
        }
        if (i < 0)
            return combinations;

        int k=1;
        while (k*candidates[i] <= target) {
            Set<List<Integer>> combinations_1 = combinationSum_(candidates, target - k*candidates[i], i);
            for (List<Integer> l : combinations_1) {
                for (int j=0; j < k; j++) {
                    l.add(candidates[i]);
                }
                combinations.add(l);
            }
            k++;
        }
        Set<List<Integer>> combinations1 = combinationSum_(candidates, target, i-1);
        combinations.addAll(combinations1);

        return combinations;
    }
}
