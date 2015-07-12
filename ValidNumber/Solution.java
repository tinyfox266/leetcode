public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0)
            return false;
        boolean hasPoint = false;
        boolean hasE = false;
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {

            } else if (c == '.') {
                if (hasPoint || s.length() == 1 || hasE)
                    return false;
                hasPoint = true;
            } else if (c == '-' || c == '+') {
                if (i != 0 || s.length() == 1 || (s.charAt(1) == '.' && s.length() == 2))
                    return false;
            } else if (c == 'e') {
                if (i == 0 || hasE || i == s.length()-1)
                    return false;
                if (isFloat(s.substring(0,i)) && isInt(s.substring(i+1)))
                    return true;
                else
                    return false;
            } else {
                return false;
            }

        }

        return true;

    }

    boolean isInt(String s) {
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (i != 0 || s.length()==1)
                    return false;
            } else if (c >= '0' && c <= '9') {

            } else {
                return false;
            }
        }

        return true;
    }

    boolean isFloat(String s) {
        boolean hasPoint = false;
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {

            } else if (c == '.') {
                if (hasPoint || s.length() == 1)
                    return false;
            } else if (c == '-' || c == '+') {
                if (s.length() == 1)
                    return false;
                if (s.length() == 2 && s.charAt(1) == '.')
                    return false;
            } else {
                return false;
            }
        }

        return true;
    }
}


