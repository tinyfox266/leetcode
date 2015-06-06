public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        
        int result=0;

        int [][] intMatrix = new int[matrix.length][matrix[0].length];
        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                intMatrix[i][j] = matrix[i][j] - '0';
            }
        }
        for (int i=0; i < matrix.length; i++) {
            if (intMatrix[i][0] == 1) {
                result = 1;
                break;
            }
        }

        for (int j=0; j < matrix[0].length; j++) {
            if (intMatrix[0][j] == 1) {
                result = 1;
                break;
            }
        }
        
        for (int i=1; i < intMatrix.length; i++) {
            for (int j=1; j < intMatrix[0].length; j++) {
                if (intMatrix[i][j] == 1) {
                    int v1 = intMatrix[i-1][j];
                    int v2 = intMatrix[i][j-1];
                    int v3 = intMatrix[i-1][j-1];
                    int min = Math.min(v1,v2);
                    min = Math.min(min, v3);
                    intMatrix[i][j] = ((int)Math.sqrt(min) + 1)*((int)Math.sqrt(min) + 1);
                    if (intMatrix[i][j] > result)
                        result = intMatrix[i][j];
                }
            }
        }

        return result;
    }
}
