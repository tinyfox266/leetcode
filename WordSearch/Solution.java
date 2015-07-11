public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return false;

        boolean [][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean res = dfs(i, j, board, visited, word);
                    if (res == true)
                        return true;
                }

            }
        }

        return false;
    }

    private boolean dfs(int i, int j, char[][] board, boolean [][]visited, String word) {
        if (word.length() == 0)
            return true;

        if (i < 0 || i >= board.length)
            return false;

        if (j < 0 || j >= board[0].length)
            return false;


        if (visited[i][j] == true)
            return false;


        if (board[i][j] != word.charAt(0))
            return false;

        visited[i][j] = true;

        boolean res1 = dfs(i-1,j, board, visited, word.substring(1, word.length()));
        if (res1 == true)
            return true;

        boolean res2 = dfs(i+1,j, board, visited, word.substring(1, word.length()));
        if (res2 == true)
            return true;

        boolean res3 = dfs(i,j-1, board, visited, word.substring(1, word.length()));
        if (res3 == true)
            return true;

        boolean res4 = dfs(i,j+1, board, visited, word.substring(1, word.length()));
        if (res4 == true)
            return true;

        visited[i][j] = false;

        return false;
    }
}

