public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;
        if (prices.length == 2){
            if (prices[0] > prices[1])
                return 0;
            return prices[1] - prices[0];
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int p:prices) {
            min = Math.min(min, p);
            max = Math.max(p-min, max);
        }

        return max;
    }
}
