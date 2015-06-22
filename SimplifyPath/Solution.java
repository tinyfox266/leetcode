public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return path;
        String res;

        String [] tokens = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String token: tokens) {
            if (token.equals(".") || token.equals(""))
                continue;
            if (token.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(token);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/" + stack.pollLast());
        }

        return sb.length()==0 ? "/" : sb.toString();
    }
}
