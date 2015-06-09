public class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1)
            return 1;


        int [] kinds = new int[n+1];
        Arrays.fill(kinds, 0);
        kinds[0] = 1;
        kinds[1] = 1;
        for (int i=2; i <= n; i++) {
            for (int j=0; j < i; j++) {
                kinds[i] += kinds[j]*kinds[i-1-j];
            }
        }

        return kinds[n];
    }
}
