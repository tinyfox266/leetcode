public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return 0;

        boolean mark[][] = new boolean[s.length()][s.length()];
        computeMark(s, mark);

        int cuts[] = new int[s.length()]; // cuts[i] min cuts of s[0,...,i];

        cuts[0] = 0;

        for (int i=1; i < s.length(); i++) {
            cuts[i]=Integer.MAX_VALUE;
            if (mark[0][i]) {
                cuts[i] = 0;
                continue;
            }
            for (int j=1; j <= i; j++) {
                if (mark[j][i]) {
                    cuts[i] = Math.min(cuts[i], cuts[j-1]+1);
                }
            }
        }

        return cuts[s.length()-1];
    }


    private void computeMark(String s, boolean mark[][]) {
        for (int i=0; i < s.length(); i++) {
            mark[i][i] = true;
        }

        for (int step=1; step < s.length(); step++) {
            for (int i=0; i+step < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i+step)) {
                    mark[i][i+step] = (step==1) || mark[i+1][i+step-1];
                } else {
                    mark[i][i+step] = false;
                }
            }
        }
    }
}

