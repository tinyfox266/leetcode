public class Solution {
   public List<String[]> solveNQueens(int n) {
        char [][] board = new char[n][n];
        for (int i=0; i < n; i++) {
            Arrays.fill(board[i],'.');
        }
        boolean [] lineUsed = new boolean[5*n];
        Arrays.fill(lineUsed, false);
        List<String[]> rst = new LinkedList<>();
        placeQueen(0, board, lineUsed, rst);
        return rst;
    }

    public void placeQueen(int row, char[][]board, boolean[]lineUsed,
                                     List<String[]> rst) {
        int n = board.length;
        if (row==n) {
            String[] sol = new String[board.length];
            for (int i=0; i < n; i++)
                sol[i] = new String(board[i]);
            rst.add(sol);
            return;
        }

        for (int i=0; i<n; i++) {
            if (lineUsed[i] || lineUsed[row-i+2*n] || lineUsed[row+i+3*n])
                continue;
            board[row][i] = 'Q';
            lineUsed[i] = true;
            lineUsed[row-i+2*n] = true;
            lineUsed[row+i+3*n] = true;
            placeQueen(row+1, board, lineUsed, rst);
            board[row][i] = '.';
            lineUsed[i] = false;
            lineUsed[row-i+2*n] = false;
            lineUsed[row+i+3*n] = false;
        }
    }
}
