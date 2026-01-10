class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int sum1 = asciiSum(s1);
        int sum2 = asciiSum(s2);

        int[][] memo = new int[s1.length()][s2.length()];
        for (int[] row : memo) Arrays.fill(row, -1);

        int commonMax = maxCommonAsciiSum(s1, s2, 0, 0, memo);
        return sum1 + sum2 - 2 * commonMax;
    }

    private int asciiSum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += s.charAt(i);
        return sum;
    }

    private int maxCommonAsciiSum(String s1, String s2, int i, int j, int[][] memo) {
        if (i == s1.length() || j == s2.length()) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = s1.charAt(i) + maxCommonAsciiSum(s1, s2, i + 1, j + 1, memo);
        } else {
            memo[i][j] = Math.max(
                maxCommonAsciiSum(s1, s2, i + 1, j, memo),
                maxCommonAsciiSum(s1, s2, i, j + 1, memo)
            );
        }

        return memo[i][j];
    }
}