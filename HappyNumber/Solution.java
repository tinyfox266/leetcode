public class Solution {
    public boolean isHappy(int n) {
        if (n==1)
            return true;
        Set set = new HashSet();

        int result=n;
        result = nextNumber(result);
        while (result != 1) {
            if (set.contains(result)) {
                return false;
            } else {
                set.add(result);
            }
            result = nextNumber(result);

        }

        return true;
    }

    public int nextNumber(int n) {
        char[] nchars = Integer.toString(n).toCharArray();
        int result = 0;
        for (int i=0; i < nchars.length; i++) {
            int idigit = (int)nchars[i]-48;
            result += idigit*idigit;
        }

        return result;
    }
}
