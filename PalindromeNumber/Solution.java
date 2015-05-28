public class Solution {
    public boolean isPalindrome(int x) {
        if (x<0)
            return false;
        int reverse=0;
        int t=x;
        while (t != 0) {
            int r = t%10;
            reverse = reverse*10+r;
            t = t/10;
        }

        System.out.println(reverse);
        return reverse == x;
    }
}
