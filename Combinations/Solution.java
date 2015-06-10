public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Set<List<Integer>> set = combineSet(n,k);
        res.addAll(set);
        return res;
    }

    public Set<List<Integer>> combineSet(int n, int k) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        if (k <= 0 || n < k)
            return res;

        if (n == k) {
            List<Integer> l = new LinkedList<Integer>();
            for (int i=1; i <=n; i++) {
                l.add(i);
            }
            res.add(l);
            return res;
        }

        if (k == 1) {
            for (int i=1; i <=n; i++) {
                List<Integer> l = new LinkedList<Integer>();
                l.add(i);
                res.add(l);
            }
        }

        Set<List<Integer>> res1 = combineSet(n - 1, k);
        res.addAll(res1);
        Set<List<Integer>> res2 = combineSet(n - 1, k - 1);
        for (List<Integer> l: res2) {
            l.add(n);
            res.add(l);
        }

        return res;
    }
}
