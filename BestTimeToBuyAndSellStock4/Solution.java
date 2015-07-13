public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        if (k <= 0)
            return 0;

        if (k > prices.length/2)
            return kIsInfiite(prices);


        int [][] lastDaySell = new int[prices.length][k+1];
        int [][] lastDayNotSell = new int[prices.length][k+1];

        Arrays.fill(lastDaySell[0], 0);
        Arrays.fill(lastDayNotSell[0], 0);
        for (int i=0; i < prices.length-1; i++) {
            lastDaySell[i][0] = 0;
            lastDayNotSell[i][0] = 0;
        }

        for (int i=1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j=1; j < k+1; j++) {
                lastDaySell[i][j] = Math.max(
                        lastDayNotSell[i-1][j-1] + diff,
                        lastDaySell[i-1][j] + diff);

                lastDayNotSell[i][j] = Math.max(
                        lastDayNotSell[i-1][j],
                        lastDaySell[i-1][j]);
            }
        }

        return Math.max(lastDaySell[prices.length-1][k], lastDayNotSell[prices.length-1][k]);
    }

    public int kIsInfiite(int[] prices) {
        int profit = 0;
        for (int i=1 ; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }

        return profit;
    }
}

