public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row0Zero = false;
        boolean column0Zero = false;
        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row0Zero=true;
                    if (j == 0) column0Zero=true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i=1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j=0; j < matrix[0].length; j++)
                    matrix[i][j] = 0;
            }
        }

        for (int j=1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i=0; i < matrix.length; i++)
                    matrix[i][j] = 0;
            }
        }

        if (row0Zero)
            Arrays.fill(matrix[0], 0);
        if (column0Zero) {
            for (int i=0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}
