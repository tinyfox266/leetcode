public class Solution {
    public String intToRoman(int num) {
        if (num <= 0)
            return null;

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        int r=num;
        String res = new String();
        while (r > 0) {
            for (int i=0; i < values.length; i++) {
                int count = r/values[i];
                for (int j=0; j < count; j++) {
                    res += numerals[i];
                }
                r = r - count*values[i];
            }
        }

        return res;
    }
}
