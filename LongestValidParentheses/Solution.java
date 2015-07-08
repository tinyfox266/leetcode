public class Solution {
    public int longestValidParentheses(String s) {
        int longest = 0;
        int len = 0;
        int last = -1;
        Stack<Integer> posStack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                posStack.push(i);
            } else {
                if (!posStack.isEmpty()) {
                    posStack.pop();
                    if (!posStack.isEmpty()) {
                        len = i - posStack.peek();
                        longest = Math.max(len, longest);
                    } else {
                        len = i - last;
                        longest = Math.max(len, longest);
                    }
                } else {
                    last = i;
                }
            }

        }
        return longest;

    }
}
