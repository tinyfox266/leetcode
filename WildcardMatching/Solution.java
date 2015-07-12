public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.replace("*","").length() > s.length())
            return false;
        boolean [][] match = new boolean[s.length()+1][p.length()+1];
        Arrays.fill(match[0], false);
        match[0][0] = true;
        for (int j=1; j <= p.length() && p.charAt(j-1)=='*'; j++) {
            match[0][j] = true;
        }
        for (int i=1; i < s.length(); i++) {
            match[i][0] = false;
        }

        for (int i=1; i <= s.length(); i++) {
            for (int j=1; j <= p.length(); j++) {
                char c = p.charAt(j-1);
                if (c == '?') {
                    match[i][j] = match[i-1][j-1];
                } else if (c == '*') {
                    match[i][j] = match[i][j-1] || match[i-1][j-1] || match[i-1][j];
                } else {
                    match[i][j] = s.charAt(i-1) ==c && match[i-1][j-1];
                }
            }
        }

        return match[s.length()][p.length()];
    }
}

