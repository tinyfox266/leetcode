c class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0)
            return b;
        if (b.length() == 0)
            return a;
        if (a.length() > b.length()) {
            char [] filled = new char[a.length()-b.length()];
            Arrays.fill(filled, '0');
            b = (new String(filled)) + b;
        } else if (a.length() < b.length()) {
            char [] filled = new char[b.length()-a.length()];
            Arrays.fill(filled, '0');
            a = (new String(filled)) + a;
        }
        int ac=0;
        String sum = new String();
        for (int i=a.length()-1; i >= 0; i--) {
            if (a.charAt(i)=='0' && b.charAt(i)=='0' && ac==0) {
                sum = '0' + sum;
                ac = 0;
            } else if (a.charAt(i)=='0' && b.charAt(i)=='0' && ac==1) {
                sum = '1' + sum;
                ac = 0;
            } else if (a.charAt(i)=='0' && b.charAt(i)=='1' && ac==0) {
                sum = '1' + sum;
                ac = 0;
            } else if (a.charAt(i)=='0' && b.charAt(i)=='1' && ac==1) {
                sum = '0' + sum;
                ac = 1;
            } else if (a.charAt(i)=='1' && b.charAt(i)=='0' && ac==0) {
                sum = '1' + sum;
                ac = 0;
            } else if (a.charAt(i)=='1' && b.charAt(i)=='0' && ac==1) {
                sum = '0' + sum;
                ac = 1;
            } else if (a.charAt(i)=='1' && b.charAt(i)=='1' && ac==0) {
                sum = '0' + sum;
                ac = 1;
            } else  {
                sum = '1' + sum;
                ac = 1;
            }
        }

        if (ac == 1)
            sum = '1' + sum;

        return sum;
    }
}
