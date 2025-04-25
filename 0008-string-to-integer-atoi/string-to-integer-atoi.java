class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int len = s.length();
        if (len == 0) return 0;

        int sign = 1;
        int i = 0;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        int number = 0;
        while (i < len && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow
            if (number > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            number = number * 10 + digit;
            i++;
        }

        return number * sign;
    }
}