public class Solution {
    public String countAndSay(int n) {
        int count, number;
        String next = "1";
        for(int i=1; i < n; i++) {
            next = nextSquenece(next);
        }

        return next;
    }

    public String nextSquenece(String s) {
        if (s.length()==0)
            return s;
        String next = new String();
        int count=1, number;
        char prec, c;
        prec = s.charAt(0);
        number = Character.getNumericValue(prec);
        for(int i=1; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == prec) {
                count++;
                prec = c;
                continue;
            } else {
                next += count;
                next += number;
                prec = c;
                count = 1;
                number = Character.getNumericValue(prec);
            }
        }
        next += count;
        next += number;
        return next;
    }
}
