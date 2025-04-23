class Solution {
    public int numTrees(int n) {
        if (n <= 1) return 1;
        return countWays(n);
    }

    private int countWays(int remaining) {
        if (remaining <= 1) return 1;

        int total = 0;
        for (int root = 1; root <= remaining; root++) {
            int left = countWays(root - 1);
            int right = countWays(remaining - root);
            total += left * right;
        }

        return total;
    }
}