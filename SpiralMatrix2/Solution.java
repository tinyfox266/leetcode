public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0)
            return null;
        if (n == 0)
            return new int[0][0];
            
        int [][] matrix = new int[n][n];
        for (int i=0; i < n; i++) {
            Arrays.fill(matrix[i], 0);
        }
        int i=0,j=0;
        matrix[0][0] = 1;
        for (int k=2; k <= n*n;) {
            int jj=0;
            for (jj=j+1; jj < n; jj++) {
                if (matrix[i][jj] == 0) {
                    matrix[i][jj] = k;
                    k++;
                }
                else
                    break;
            }
            j = jj-1;

            int ii=0;
            for (ii=i+1; ii < n; ii++) {
                if (matrix[ii][j] == 0) {
                    matrix[ii][j] = k;
                    k++;
                }else
                    break;
            }
            i = ii-1;

            for (jj=j-1; jj >= 0; jj--) {
                if (matrix[i][jj] == 0) {
                    matrix[i][jj] = k;
                    k++;
                } else
                    break;
            }
            j = jj+1;

            for (ii=i-1; ii >= 0; ii--) {
                if (matrix[ii][j] == 0) {
                    matrix[ii][j] = k;
                    k++;
                } else
                    break;
            }
            i = ii+1;
        }

        return matrix;
    }
}
