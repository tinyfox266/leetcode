public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        if(needle.length()>haystack.length())
            return -1;
        int i = 0, j = 0;
        while (j < needle.length()&&i<haystack.length()) {
         if(needle.charAt(j)==haystack.charAt(i)){
             i++;
             j++;

         }else{
             i=i-(j-1);
             j=0;

         }
        }
        if(j==needle.length())
            return i-j;
        else if(i==haystack.length())
            return -1;

        else return 0;
    }
}
