class Solution {

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            int step = countSteps(n, curr, curr + 1);
            if (step <= k) {
                curr++;
                k -= step;
            } else {
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    private int countSteps(int n, long prefix1, long prefix2) {
        if (prefix1 > n) return 0;
        return (int)(Math.min(n + 1L, prefix2) - prefix1) +
               countSteps(n, prefix1 * 10, prefix2 * 10);
    }
}