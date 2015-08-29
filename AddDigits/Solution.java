public class Solution {
    public int addDigits(int num) {

        while (num > 9) {
            char [] digits = Integer.toString(num).toCharArray();

            num=0;
            for (int i=0; i < digits.length; i++) {
                num += digits[i]-'0';
            }
        }

        return num;
    }
}

