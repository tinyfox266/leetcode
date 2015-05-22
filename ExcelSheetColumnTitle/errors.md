# Excel Sheet Column Title

## Error
Wrong Answer

Input:  1

Output: "@A"

Expected:   "A"

## Submitted Code
    public class Solution {
        public String convertToTitle(int n) {
            String title = new String();
            if (n < 1)
                return null;

            int r = n%26;
            int q = n/26;
            title = (char)(r+64) + title;
            while (q > 26) {
                q = r/26;
                r = r%26;
                title = (char)(r+64) + title;
            }

            title = (char) (q + 64) + title;


            return title;

        }
    }


-------------------------------------------------
-------------------------------------------------

## Error
Wrong Answer

Input:  26

Output: "A@"

Expected:   "Z"

## Submitted Code

    public class Solution {
        public String convertToTitle(int n) {
            String title = new String();
            if (n < 1)
                return null;

            int r = n%26;
            int q = n/26;
            title = (char) (r + 64) + title;

            while (q != 0) {
                r = q%26;
                q = q/26;
                title = (char)(r+64) + title;

            }


            return title;

        }
    }

-------------------------------------------------
-------------------------------------------------


