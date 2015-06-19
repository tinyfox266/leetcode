public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0]==null || matrix[0].length == 0)
            return l;

        boolean [][] mark = new boolean[matrix.length][matrix[0].length];
        for (int i=0; i < mark.length; i++) {
            Arrays.fill(mark[i], false);
        }
        int i=0, j=0;
        mark[0][0] = true;
        l.add(matrix[0][0]);
        while (true) {
            int jj;
            for (jj=j+1; jj < matrix[0].length; jj++) {
                if (mark[i][jj] == false) {
                    l.add(matrix[i][jj]);
                    mark[i][jj] = true;
                } else {
                    break;
                }
            }
            j = jj-1;
            if (cannotGo(mark, i+1, j))
                break;
            int ii;
            for (ii=i+1; ii < matrix.length; ii++) {
                if (mark[ii][j] == false) {
                    l.add(matrix[ii][j]);
                    mark[ii][j] = true;
                } else {
                    break;
                }
            }
            i = ii-1;
            if (cannotGo(mark, i, j-1))
                break;
            for (jj=j-1; jj >= 0; jj--) {
                if (mark[i][jj] == false) {
                    l.add(matrix[i][jj]);
                    mark[i][jj] = true;
                } else {
                    break;
                }
            }
            j = jj+1;
            if (cannotGo(mark, i-1, j))
                break;
            for (ii=i-1; ii >=0; ii--) {
                if (mark[ii][j] == false) {
                    l.add(matrix[ii][j]);
                    mark[ii][j] = true;
                } else {
                    break;
                }
            }
            i = ii+1;
            if (cannotGo(mark, i, j+1))
                break;

        }

        return l;
    }

    public boolean cannotGo(boolean [][] mark, int i, int j) {
        if (i < 0 || i >= mark.length || j < 0 || j >= mark[0].length)
            return true;

        return mark[i][j];
    }
}
