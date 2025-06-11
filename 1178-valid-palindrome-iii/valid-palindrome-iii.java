class Solution {
    Integer memo[][];
    int isValidPalindrome(String s, int i, int j) {

        if (i == j)
            return 0;

        if (i == j - 1)
            return s.charAt(i) != s.charAt(j) ? 1 : 0;

        if (memo[i][j] != null)
            return memo[i][j];

        if (s.charAt(i) == s.charAt(j))
            return memo[i][j] = isValidPalindrome(s, i + 1, j - 1);

        return memo[i][j] = 1 + Math.min(isValidPalindrome(s, i + 1, j), isValidPalindrome(s, i, j - 1));
    }
public boolean isValidPalindrome(String s, int k) {
        memo = new Integer[s.length()][s.length()];

        return isValidPalindrome(s, 0, s.length() - 1) <= k;
    }
};