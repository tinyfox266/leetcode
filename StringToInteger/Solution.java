public class Solution {
    public int myAtoi(String str) {
        long x=0;
        int flag=1;
        str = str.trim();
        if (str.length() <1)
            return 0;
        int start=0;
        if (str.charAt(0) == '-') {
            flag = -1;
            start++;
        } else if (str.charAt(0) == '+') {
            flag = 1;
            start++;
        }
        for (int i=start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                x = x*10 + (c-'0');
                if (x > Integer.MAX_VALUE) {
                    if (flag > 0)
                        x = Integer.MAX_VALUE;
                    else {
                        x = Integer.MIN_VALUE;
                        flag = 1;
                    }
                    break;
                }
            } else {
                break;
            }
        }

        return (int)x*flag;
    }
}
