public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        return searchMatrixHelper(matrix, target, matrix.length-1, 0);


    }


    public boolean searchMatrixHelper(int[][] matrix, int target,
                                      int rowEnd, int col) {
        if (col >= matrix[0].length)
            return false;

        int low=0, high=rowEnd;
        while (low <= high) {
           int mid = low + (high-low)/2;
            if (matrix[mid][col] == target) {
                return true;
            } else if (matrix[mid][col] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        int row=high;

        return searchMatrixHelper(matrix, target, row, col+1);

    }
}

