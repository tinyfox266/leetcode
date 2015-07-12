public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;

        int [] maxBefore = new int[prices.length];
        maxBefore[0] = 0;

        int min=prices[0];
        for (int i=1; i < prices.length; i++) {
            min = Math.min(min, prices[i-1]);
            maxBefore[i] = Math.max(maxBefore[i-1], prices[i-1]-min);
        }

        int max=prices[prices.length-1];
        int ret = 0;
        for (int i=prices.length-1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            ret = Math.max(ret, maxBefore[i] + max - prices[i]);
        }




        return ret;
    }
}

