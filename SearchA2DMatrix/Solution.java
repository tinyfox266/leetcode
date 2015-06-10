public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int low=0, high=matrix.length-1;
        while (low < high) {
            int mid=high-(high-low)/2;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] < target) {
                low = mid;
            } else {
                high = mid-1;
            }
        }

        for (int j=0; j < matrix[0].length; j++){
            if (matrix[low][j] == target)
                return true;
        }

        return false;


    }
}
