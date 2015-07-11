public class Solution {
    public String getPermutation(int n, int k) {
        if (n <= 0 || k <=0)
            return null;

        StringBuilder res =  new StringBuilder();

        int [] factors = new int[n+1];
        computeFactors(factors);
        int [] nums = new int[n];
        for (int i=0; i < nums.length; i++) {
            nums[i] = i+1;
        }

        k = k-1;
        for (int i=1; i <= n; i++) {
            int c = k/factors[n-i];
            res.append(nums[c]);
            k = k%factors[n-i];
            for (int j=c; j < n-1; j++) {
                nums[j] = nums[j+1];
            }
        }

        return res.toString();
    }

    public void computeFactors(int [] factors) {
        factors[0] = 1;
        for (int i=1; i < factors.length; i++) {
            factors[i] = factors[i-1]*i;
        }
    }
}

