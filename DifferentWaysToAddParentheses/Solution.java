public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
            return new LinkedList<Integer>();
        }
        char c;
        List<Integer> ops = new LinkedList<Integer>();
        
        for (int i=0; i < input.length(); i++) {
            c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                ops.add(i);
            }
        }
        
        if (ops.isEmpty()) {
            List<Integer> res = new LinkedList<Integer>();
            res.add(Integer.parseInt(input));
            return res;
        }

        List<Integer> res = new LinkedList<Integer>();
        
        for (int k=0; k < ops.size(); k++) {
            int pos = ops.get(k);
            List<Integer> subRes1 = diffWaysToCompute(input.substring(0,pos));   
            List<Integer> subRes2 = diffWaysToCompute(input.substring(pos+1));
            char op = input.charAt(pos);
            switch(op) {
                case '+':
                    for (Integer n1: subRes1) {
                        for (Integer n2: subRes2) {
                            res.add(n1+n2);
                        }
                    }
                    break;
                case '-':
                    for (Integer n1: subRes1) {
                        for (Integer n2: subRes2) {
                            res.add(n1-n2);
                        }
                    }
                    break;
                case '*':
                    for (Integer n1: subRes1) {
                        for (Integer n2: subRes2) {
                            res.add(n1*n2);
                        }
                    }
            }
            
        }
        
        return res;
    }
}
