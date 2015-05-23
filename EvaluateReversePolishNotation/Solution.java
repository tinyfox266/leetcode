public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i=0; i < tokens.length; i++) {
            String token = tokens[i];
            if (!isOperator(token)) {
                s.push(Integer.parseInt(token));
            } else {
                int right = s.pop();
                int left = s.pop();
                switch(token) {
                    case "+": s.push(left+right);
                        break;
                    case "-": s.push(left-right);
                        break;
                    case "*": s.push(left*right);
                        break;
                    case "/": s.push(left/right);
                        break;
                }

            }
        }

        return s.pop();
    }

    public boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;

        return false;
    }
}
