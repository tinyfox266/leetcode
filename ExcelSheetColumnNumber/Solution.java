public class Solution {
    public int titleToNumber(String s) {
        String lowerCase = s.toLowerCase();
        int n=0;
        for (int i=0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            n += (c-96)*Math.pow(26,(lowerCase.length()-i-1));
        }

        return n;
    }
}
