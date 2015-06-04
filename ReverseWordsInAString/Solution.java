public class Solution {
    public String reverseWords(String s) {
        String reversedStr = new String();
        String word = new String();

        if (s.length() == 0)
            return s;

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                word = word + c;
            } else {
                if (word.equals(""))
                    continue;
                reversedStr = " " + word + reversedStr;
                word = "";
            }
        }

        if (s.charAt(s.length()-1) != ' ') {
            reversedStr = word + reversedStr;

        }

        return reversedStr.trim();
    }
}
