public class Solution {
    int [] ones;
    int [] onesSum;

    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;

        int num = digitNum(n);
        ones = new int[num+1];
        onesSum = new int[num+1];
        ones[0] = 0;
        onesSum[0] = 0;
        for (int i=1; i <= num; i++) {
            ones[i] = 9*onesSum[i-1] + (int)Math.pow(10, i-1);
            onesSum[i] = onesSum[i-1] + ones[i];
        }

        return countDigitStrOne(Integer.toString(n));
    }

    public int countDigitStrOne(String n) {
        if (n.length() == 1)
            return n.charAt(0)=='0'?0:1;

        int count = countDigitStrOne(n.substring(1));

        char highest = n.charAt(0);
        if (highest == '0') {
            return countDigitStrOne(n.substring(1));
        } if (highest == '1') {
            return Integer.parseInt(n.substring(1)) + 1 +
                    onesSum[n.length()-1] +
                    count;
        } else {
            return ((int) Math.pow(10, n.length()-1)) +
                    (highest-'0'-1) * onesSum[n.length()-1] +
                    onesSum[n.length()-1] +
                    count;
        }
    }

    public int digitNum(int n) {
        int i=0;
        while (n > 0) {
            i++;
            n = n/10;
        }

        return i;
    }
}

