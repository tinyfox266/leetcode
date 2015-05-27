public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
            
        int rowSize = (int) (s.length());
        char [][] zigZagCode = new char[numRows][rowSize];
        for (int i=0; i < zigZagCode.length; i++) {
            for (int j=0; j < zigZagCode[i].length; j++) {
                zigZagCode[i][j] = ' ';
            }
        }
        int flag=0;
        for (int k=0,i=0,j=0; k < s.length();) {
            if (flag==0) {
                if (i<numRows) {
                    zigZagCode[i][j] = s.charAt(k);
                    k++;
                    i++;
                } else {
                    flag = 1;
                    i-=2;
                    j++;
                }
            } else {
                if (i>0) {
                    zigZagCode[i][j] = s.charAt(k);
                    i--;
                    j++;
                    k++;
                } else{
                    flag = 0;
                }
            }
        }

        String zigZagStr = new String();
        for (int i=0; i < zigZagCode.length; i++) {
            for (int j=0; j < zigZagCode[i].length; j++) {
                if (zigZagCode[i][j] != ' ')
                    zigZagStr = zigZagStr+zigZagCode[i][j];
            }
        }
        return zigZagStr;
    }
}
