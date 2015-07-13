public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 ||
                dungeon[0] == null || dungeon[0].length == 0)
            return 1;

        int xlen = dungeon.length;
        int ylen = dungeon[0].length;

        int [][] dp = new int[xlen][ylen];

        dp[xlen-1][ylen-1] = Math.max(0-dungeon[xlen-1][ylen-1]+1,1);
        for (int i=xlen-2; i >= 0; i--) {
            dp[i][ylen-1] = Math.max(dp[i+1][ylen-1]-dungeon[i][ylen-1], 1);
        }

        for (int j=ylen-2; j >= 0; j--) {
            dp[xlen-1][j] = Math.max(dp[xlen-1][j+1]-dungeon[xlen-1][j], 1);
        }

        for (int i=xlen-2; i >= 0; i--) {
            for (int j=ylen-2; j >= 0; j--) {
                dp[i][j] = Math.max( Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }
}
