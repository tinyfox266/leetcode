public class Solution {
    public String longestPalindrome(String s) {
        int max=0;
        int left=0, right=0;

        for (int i=0; i < s.length(); i++) {
            int len;
            int k=1;
            while (i-k >= 0 && i+k < s.length() && s.charAt(i-k) == s.charAt(i+k)) {
                k++;
            }
            len = 2*(k-1)+1;
            if (len > max) {
                max = len;
                left = i-k+1;
                right = i+k+1-1;
            }


            if (i+1 < s.length()) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    k=1;
                    while (i-k >= 0 && i+1+k < s.length() && s.charAt(i-k) == s.charAt(i+1+k)) {
                        k++;
                    }
                    len = 2*(k-1)+2;
                    if (len > max) {
                        max = len;
                        left = i-k+1;
                        right = i+1+k-1+1;
                    }
                }
            }
        }

        return s.substring(left, right);
    }
}
