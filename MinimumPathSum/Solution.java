public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int [][] minPathSum = new int[grid.length][grid[0].length];
        minPathSum[0][0] = grid[0][0];
        for (int i=1; i < grid.length; i++) {
            minPathSum[i][0] = minPathSum[i-1][0] + grid[i][0];
        }

        for (int j=1; j < grid[0].length; j++) {
            minPathSum[0][j] = minPathSum[0][j-1] + grid[0][j];
        }

        for (int i=1; i < grid.length; i++){
            for (int j=1; j < grid[0].length; j++) {
                minPathSum[i][j] = Math.min(minPathSum[i-1][j], minPathSum[i][j-1]) + grid[i][j];
            }
        }

        return minPathSum[grid.length-1][grid[0].length-1];
    }
}
