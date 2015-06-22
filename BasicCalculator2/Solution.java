public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int number=0;
        LinkedList<Integer> operandList = new LinkedList<Integer>();
        LinkedList<Character> operatorList = new LinkedList<Character>();


        int flag=0;
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            else if (Character.isDigit(c)) {
                while (Character.isDigit(c) && i < s.length()) {
                    number = number * 10 + c - '0';
                    i++;
                    if (i < s.length())
                        c = s.charAt(i);
                }
                i--;
                if (flag==1) {
                    int operand1 = operandList.pollLast();
                    char operator = operatorList.pollLast();
                    switch(operator) {
                        case '*': operandList.add(operand1 * number);
                            break;
                        case '/': operandList.add(operand1 / number);
                            break;
                    }
                    flag = 0;
                } else {
                    operandList.add(number);
                }
                number = 0;
            } else if (c == '+' || c == '-') {
                operatorList.add(c);
            } else if (c == '*' || c == '/') {
                operatorList.add(c);
                flag = 1;
            }
        }

        while (!operatorList.isEmpty()) {
            char operator = operatorList.poll();
            int operand1 = operandList.poll();
            int operand2 = operandList.poll();
            switch (operator) {
                case '+': operandList.add(0, operand1+operand2);
                    break;
                case '-': operandList.add(0, operand1-operand2);
                    break;
            }
        }
        return operandList.pop();
    }
}
