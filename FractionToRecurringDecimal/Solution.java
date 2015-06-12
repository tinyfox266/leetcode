public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        if (denominator == 0)
            return "";

        long num = numerator;
        long den = denominator;
        String ret = new String();
        if (num < 0 && den > 0
                || num > 0 && den < 0) {
            ret += "-";
            num = Math.abs(num);
            den = Math.abs(den);
        }

        long quotient = num/den;
        long r = num%den;
        ret += Long.toString(quotient);
        if (r != 0)
            ret += '.';
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while (r != 0) {
            if (map.get(r) != null) {
                StringBuilder builder = new StringBuilder(ret);
                builder.insert(map.get(r),new String("("));
                ret = builder.toString() + ')';
                return ret;
            }
            map.put(r, ret.length());
            quotient = r*10/den;
            ret += quotient;
            r = (r*10)%den;
        }

        return ret;
    }

}
