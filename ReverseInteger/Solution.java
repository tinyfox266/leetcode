public class Solution {
    public int reverse(int x) {
        String s = Integer.toString(x);
        String reverseStr = new String();
        for (int i=s.length()-1; i >=1 ; i--) {
            reverseStr += s.charAt(i);
        }
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
            reverseStr = s.charAt(0) + reverseStr;
        else
            reverseStr += s.charAt(0);
        try {
            x = Integer.parseInt(reverseStr);
        } catch(NumberFormatException e) {
            return 0;
        }
        return x;
    }
}
