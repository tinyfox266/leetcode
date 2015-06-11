public class Solution {
    public double myPow(double x, int n) {
        if (n==0 || x == 1)
            return 1;
        if (x == -1)
            return n%2==0?1:-1;
        if (n<0) {
            n = -n;
            x = 1/x;
        }
        double pow=x;
        double tmp=1;
        while (n != 0) {
            if (n%2 == 1) {
                tmp = tmp*pow;
            }
            pow = pow*pow;
            n = n >> 1;
        }

        return tmp;

    }
}
