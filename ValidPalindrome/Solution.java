class Solution {
    public boolean isPalindrome(String s) {
        if (s.length()==0)
            return true;

        for (int i=0, j=s.length()-1; i < j;) {
            while (!isAlphaNumber(s.charAt(i)) && i < j)
                i++;
            while (!isAlphaNumber(s.charAt(j)) && i < j)
                j--;
            if ( i >= j)
                break;
            if (!(s.charAt(i)==s.charAt(j) || Math.abs(s.charAt(i)-s.charAt(j))==32 ))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphaNumber(char c) {
        if ((c >= 'a' && c <= 'z') ||
                (c >= 'A' && c<= 'Z') ||
                (c >= '0' && c <= '9')) {
            return true;
        }

        return false;
    }
}
