public class Solution {
    public String numberToWords(int num) {
        String res = "";
        String [] thousands = {"Zero", "Thousand", "Million", "Billion"};

        if (num == 0) {
            return "Zero";
        }

        int i=0;
        while (num > 0) {
            int r = num%1000;
            int d = num/1000;
            num = d;
            if (r == 0) {
                i++;
                continue;
            }
            if (i == 0) {
                res = smallNumberToWords(r) +res;
            } else {
                res = smallNumberToWords(r) + " " + thousands[i] + " " +res;
            }
            i++;
        }

        return res.trim();
    }

    public String smallNumberToWords(int num) {
        if (num == 0)
            return "";

        String [] smallNumber = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"
        };

        String [] tenNumber = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        int h = num/100;
        int t = (num-h*100)/10;
        int d = num%10;

        String res = "";
        if (h != 0) {
            res = res + " " + smallNumber[h] + " "+ "Hundred";
        }
        
        if (t == 0 && d == 0) {
            return res.trim();
        }
        
        if (num % 100 < 20) {
            res = res + " " + smallNumber[num%100];
        } else if (d == 0) {
            res = res + " "  + tenNumber[t];
        }else {
            res  = res + " " + tenNumber[t]  + " "+ smallNumber[d];
        }

        return res.trim();

    }
}
