public class Solution {
    public String multiply(String num1, String num2) {
        String prod = "0";
        for (int i=num1.length()-1; i >= 0; i--) {
            StringBuilder acc = new StringBuilder("0");
            StringBuilder prodStr = new StringBuilder();
            for (int k=0; k < num1.length()-1-i; k++) {
                acc.insert(0, '0');
                prodStr.insert(0, '0');
            }
            for (int j=num2.length()-1; j >= 0; j--) {
                int d1=num1.charAt(i)-'0', d2=num2.charAt(j)-'0';
                int product=d1*d2;
                prodStr.insert(0,product%10);
                acc.insert(0, product/10);
            }

            prod = plus(prod, prodStr.toString());
            prod = plus(prod, acc.toString());

        }

        int start=0;
        for (int i=0; i < prod.length(); i++) {
            if (prod.charAt(i) == '0')
                start++;
            else
                break;
        }

        prod = prod.substring(start, prod.length());
        if (prod.length() == 0)
            return "0";

        return prod;
    }



    public String plus(String nums1, String nums2) {
        StringBuilder builder = new StringBuilder();
        if (nums1.length() < nums2.length()) {
            char [] pad = new char[nums2.length()- nums1.length()];
            Arrays.fill(pad, '0');
            nums1 = (new String(pad)) + nums1;
        } else if (nums2.length() < nums1.length()) {
            char [] pad = new char[nums1.length()- nums2.length()];
            Arrays.fill(pad, '0');
            nums2 = (new String(pad)) + nums2;
        }
        int acc=0;
        for (int i=nums1.length()-1; i >= 0; i--) {
            char d1=nums1.charAt(i), d2=nums2.charAt(i);
            int sum=(d1-'0') + (d2-'0') +acc;
            if (sum < 10) {
                acc=0;
                builder.insert(0,sum);
            } else {
                acc=1;
                builder.insert(0,sum-10);
            }
        }

        if (acc == 1)
            builder.insert(0,'1');

        return builder.toString();
    }
}
