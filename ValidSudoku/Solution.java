public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i < 9; i++) {
            Set<Character> lineSet = new HashSet<Character>();
            for (int j=0; j < 9; j++) {
                char c = board[i][j];
                if (!Character.isDigit(c))
                    continue;
                if (lineSet.contains(c))
                    return false;
                lineSet.add(c);
            }
            lineSet.clear();
        }

        for (int i=0; i < 9; i++) {
            Set<Character> lineSet = new HashSet<Character>();
            for (int j=0; j < 9; j++) {
                char c = board[j][i];
                if (!Character.isDigit(c))
                    continue;
                if (lineSet.contains(c))
                    return false;
                lineSet.add(c);
            }
            lineSet.clear();
        }

        for (int i=0; i < 3; i++) {
            for (int j=0; j < 3; j++) {
                Set<Character> lineSet = new HashSet<Character>();
                for (int k1=0; k1 < 3; k1++) {
                    for (int k2=0; k2 < 3; k2++) {
                        char c = board[i*3+k1][j*3+k2];
                        if (!Character.isDigit(c))
                            continue;
                        if (lineSet.contains(c))
                            return false;
                        lineSet.add(c);
                    }
                }
                lineSet.clear();
            }
        }
        return true;
    }
}
