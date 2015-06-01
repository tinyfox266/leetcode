public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0)
            return true;

        Stack stack = new Stack();
        for (int i=0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.empty() || !stack.pop().equals(s.charAt(i))) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }

        }

        if (!stack.empty())
            return false;
        return true;
    }
}
