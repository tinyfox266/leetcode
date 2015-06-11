public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int [][] maps = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for (int i=0; i < maps.length; i++) {
            Arrays.fill(maps[i], Integer.MIN_VALUE);
        }
        return minimumTotal(triangle, 0, 0, maps);
    }

    public int minimumTotal(List<List<Integer>> triangle, int row, int col, int [][] maps) {
        if (row >= triangle.size())
            return 0;
        if (maps[row][col] > Integer.MIN_VALUE)
            return maps[row][col];

        int n = triangle.get(row).get(col);
        int sum1 = minimumTotal(triangle, row+1, col, maps);
        int sum2 = minimumTotal(triangle, row+1, col+1, maps);
        maps[row][col] = Math.min(sum1,sum2) + n;
        return maps[row][col];
    }
}
