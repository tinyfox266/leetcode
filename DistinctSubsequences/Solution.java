public class Solution {
    public int numDistinct(String s, String t) {
        if (t == null || t.length() == 0)
            return 1;
        if (s == null || s.length() == 0)
            return 0;

        int [][] distinct = new int[s.length()+1][t.length()+1];
        for (int i=0; i < s.length()+1; i++) {
            distinct[i][0] = 1;
        }

        for (int j=1; j < t.length()+1; j++) {
            distinct[0][j] = 0;
        }

        for (int i=1; i < s.length()+1; i++) {
            for (int j=1; j < t.length()+1; j++) {
                char c1 = s.charAt(i-1);
                char c2 = t.charAt(j-1);
                if (c1 == c2) {
                    distinct[i][j] = distinct[i-1][j-1] + distinct[i-1][j];
                } else {
                    distinct[i][j] = distinct[i-1][j];
                }
            }
        }

        return distinct[s.length()][t.length()];
    }
}
