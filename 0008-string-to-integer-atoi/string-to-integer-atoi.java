class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        int sign = 1;
        int index = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        long ans = rec(s, index, 0L);

        ans = ans * sign;

        if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) ans;
    }

    private long rec(String s, int index, long num) {
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
            return num;
        }

        num = num * 10 + (s.charAt(index) - '0');

        // clamp early to avoid overflow in recursion
        if (num > (long) Integer.MAX_VALUE + 1) {
            return num;
        }

        return rec(s, index + 1, num);
    }
}