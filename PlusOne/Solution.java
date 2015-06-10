public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;

        int ac=1;
        for (int i=digits.length-1; i >= 0; i--) {
            int sum = digits[i]+ac;
            if (sum >= 10) {
                digits[i] = sum - 10;
                ac = 1;
            } else {
                digits[i] = sum;
                ac = 0;
            }
        }

        if (ac == 0)
            return digits;

        int [] sumDigits = new int[digits.length+1];
        sumDigits[0] = 1;
        for (int i=0; i < digits.length; i++) {
            sumDigits[i+1] = digits[i];
        }

        return sumDigits;

    }
}
