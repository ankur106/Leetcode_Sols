class Solution {
    public int maxDiff(int num) {
        int max = replace(num, getFirstReplaceDigit(num, true), 9);
        int min = replace(num, getFirstReplaceDigit(num, false), getMinReplacement(num));
        return max - min;
    }

    private int replace(int num, int x, int y) {
        StringBuilder sb = new StringBuilder();
        for (char c : String.valueOf(num).toCharArray()) {
            if (c - '0' == x) {
                sb.append((char) (y + '0'));
            } else {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }

    private int getFirstReplaceDigit(int num, boolean maximize) {
        String s = String.valueOf(num);
        if (maximize) {
            for (char c : s.toCharArray()) {
                if (c != '9') return c - '0';
            }
        } else {
            char first = s.charAt(0);
            if (first != '1') return first - '0';
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '0' && c != '1') return c - '0';
            }
        }
        return -1;
    }

    private int getMinReplacement(int num) {
        String s = String.valueOf(num);
        if (s.charAt(0) != '1') return 1; // If first digit is not 1, replace it with 1
        return 0; // Otherwise replace next eligible digit with 0
    }
}