public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (dividend == 0)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (dividend != Integer.MIN_VALUE && divisor == Integer.MIN_VALUE)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE)
            return 1;

//        if (dividend == Integer.MIN_VALUE) {
//            dividend
//        }
        int flag=1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
            flag = -1;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        int res=0;
        int div = dividend;
        while (div <= divisor) {
            long tmp = divisor;
            long digit=1;
            while (tmp >= div) {
                tmp = tmp << 1;
                digit = digit << 1;
            }
            res += digit>>1;
            div = div - (int)(tmp >> 1);
        }

        return flag*res;
    }
}

