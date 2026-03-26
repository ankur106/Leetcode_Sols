class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int number = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (operator) {
                    case '+': stack.push(number); break;
                    case '-': stack.push(-number); break;
                    case '*': stack.push(stack.pop() * number); break;
                    case '/': stack.push(stack.pop() / number); break;
                }
                operator = c;
                number = 0;
            }
        }

        int result = 0;
        for (int n : stack) result += n;
        return result;
    }
}