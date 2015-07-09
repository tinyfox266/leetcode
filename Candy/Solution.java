public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;

        int [] candy = new int[ratings.length];

        Arrays.fill(candy, 1);
        for (int i=1; i < candy.length; i++) {
            if (ratings[i] > ratings[i-1])
                candy[i] = candy[i-1]+1;
        }

        for (int i=candy.length-2; i >=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                if (i > 0 && ratings[i-1] < ratings[i]) {
                    candy[i] = Math.max(candy[i-1], candy[i+1])+1;
                } else {
                    candy[i] = candy[i+1]+1;
                }
            }
        }

        int sum = 0;
        for (int i=0; i < candy.length; i++) {
            sum += candy[i];
        }

        return sum;
    }
}
