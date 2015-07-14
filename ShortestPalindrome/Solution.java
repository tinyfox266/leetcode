public class Solution {
    
    // change my reverse funtion to reverse() of StringBuilder
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;

        String t = s + '#' + reverse(s);
        int [] next = new int[t.length()+1];
        // next[i]表示s[0...i-1]中最长共同前后缀的长度。
        next[0] = -1;
        for (int i=1; i <= t.length(); i++) {
            int j=i-1;
            j = next[j];
            while (j >= 0 && t.charAt(j) != t.charAt(i-1)) {
                j = next[j];
            }
            next[i] = j+1;
        }

        String pad = s.substring(next[t.length()]);
        return reverse(pad) + s;
    }
    
    String reverse(String s) {
        return (new StringBuilder(s)).reverse().toString();
    }
    
}
