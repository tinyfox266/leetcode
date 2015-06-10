public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (D-B)*(C-A) + (H-F)*(G-E);
        if (A >= G || B >= H || C <= E || D <= F)
            return total;
        
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        int left = Math.max(A,E);
        int right = Math.min(C,G);
        
        return total - (top-bottom)*(right-left);         
    }
}
