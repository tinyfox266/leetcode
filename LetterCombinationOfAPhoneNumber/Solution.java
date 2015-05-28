public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> strs = new LinkedList<String>();
        String []codes = {"","","abc","def","ghi","jkl","mno",
                "pqrs","tuv","wxyz"};
        if (digits.length() == 0)
            return strs;
        String code = codes[(int)(digits.charAt(0)-'0')];
        if (digits.length() == 1) {
            for (int i=0; i < code.length(); i++) {
                strs.add(code.charAt(i)+"");
            }
        }


        List<String> tailStrs = letterCombinations(digits.substring(1,digits.length()));
        for (int i=0; i < code.length(); i++) {
            for (int j=0; j < tailStrs.size(); j++)
                strs.add(code.charAt(i) + tailStrs.get(j));
        }

        return strs;
    }
}
