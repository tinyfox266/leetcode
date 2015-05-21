public class Solution {
    public int trailingZeroes(int n) {
        int fiveCount=0;
        long maxFive = (long) (Math.log(n)/Math.log(5));

        for (int i=1; i <= maxFive; i++) {
            fiveCount += (int) (n/Math.pow(5,i));
        }


        return fiveCount;
    }
}
