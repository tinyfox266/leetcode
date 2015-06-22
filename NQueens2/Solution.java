public class Solution {
    int res=0;
    public int totalNQueens(int n) {
        helper(new int[n], 0);
        return res;
    }
    
    public void helper(int [] state, int r) {
        if (r == state.length) {
            res++;
            return;
        }
        for (int c=0; c < state.length; c++) {
            if (isValid(state, c, r)) {
                state[r] = c;
                helper(state, r+1);
            }
        }
    }
    
    private boolean isValid(int [] state, int c, int r) {
        for (int i=0; i < r; i++) {
            if (state[i] == c || Math.abs(state[i]-c) == r-i) {
                return false;
            }
        }
        
        return true;
    }
}
