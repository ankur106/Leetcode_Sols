class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (countLessOrEqual(m, n, mid) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // count of table entries <= x
    private int countLessOrEqual(int m, int n, int x) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, x / i);
        }
        return count;
    }
}