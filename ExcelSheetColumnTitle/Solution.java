public class Solution {
    public String convertToTitle(int n) {
        String title = new String();
        if (n < 1)
            return null;

        int r = (n-1)%26;
        int q = (n-1)/26;
        title = (char) (r + 65) + title;

        while (q != 0) {
            r = (q-1)%26;
            q = (q-1)/26;
            title = (char)(r+65) + title;

        }


        return title;

    }
}
