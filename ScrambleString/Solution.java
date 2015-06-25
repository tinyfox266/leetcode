public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2)
            return false;
        if (len1 == 1)
            return s1.equals(s2);

        char [] schars1 = s1.toCharArray();
        char [] schars2 = s2.toCharArray();
        Arrays.sort(schars1);
        Arrays.sort(schars2);
        for (int i=0; i < schars1.length; i++) {
            if (schars1[i] != schars2[i])
                return false;
        }

        String s11, s12, s21, s22;
        for (int i=1; i < s1.length(); i++) {
            s11 = s1.substring(0,i);
            s12 = s1.substring(i,s1.length());
            s21 = s2.substring(0,i);
            s22 = s2.substring(i,s2.length());
            boolean res = isScramble(s11, s21) && isScramble(s12, s22);
            if (res == false) {
                s21 = s2.substring(0,s2.length()-i);
                s22 = s2.substring(s2.length()-i, s2.length());
                res = isScramble(s11, s22) && isScramble(s12, s21);
            }

            if (res)
                return true;
        }

        return false;
    }
}
