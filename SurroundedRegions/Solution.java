public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 ||
                board[0] == null || board[0].length == 0)
            return;
        boolean [][] mark = new boolean[board.length][board[0].length];
        for (int i=0; i < mark.length; i++) {
            Arrays.fill(mark[i], true);
        }
        for (int i=0; i < board.length; i++) {
            if (board[i][0] == 'O' && mark[i][0] != false) {
                mark[i][0] =false;
                dfs(board, mark, i, 1);
            }
            if (board[i][board[0].length-1] == 'O' && mark[i][board[0].length-1] != false) {
                mark[i][board[0].length-1] = false;
                dfs(board, mark, i, board[0].length - 2);
            }
        }
        for (int j=0; j < board[0].length; j++) {
            if (board[0][j] == 'O' && mark[0][j] != false) {
                mark[0][j] = false;
                dfs(board, mark, 1, j);
            }
            if (board[board.length-1][j] == 'O' && mark[board.length-1][j] != false) {
                mark[board.length-1][j] = false;
                dfs(board, mark, board.length - 2, j);
            }
        }

        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                if (mark[i][j] == true) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board, boolean [][] mark, int i, int j) {
        if (i <= 0 || i >= board.length)
            return;
        if (j <= 0 || j >= board[0].length)
            return;
        if (board[i][j] != 'O')
            return;
        if (mark[i][j] == false)
            return;

        mark[i][j] = false;
        dfs(board, mark, i-1, j);
        dfs(board, mark, i+1, j);
        dfs(board, mark, i, j-1);
        dfs(board, mark, i, j+1);
    }
}
