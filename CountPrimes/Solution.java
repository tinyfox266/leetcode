public class Solution {
    public int countPrimes(int n) {
        boolean [] numbers = new boolean [n];
        for (int i=0; i < n; i++) {
            numbers[i] = true;
        }

        int count=0;

        for (int i=2; i<n; i++) {
            if (numbers[i]==true)
                count++;
            for (int j=2; i*j<n; j++) {
                numbers[i*j]=false;
            }
        }

        return count;
    }
}
