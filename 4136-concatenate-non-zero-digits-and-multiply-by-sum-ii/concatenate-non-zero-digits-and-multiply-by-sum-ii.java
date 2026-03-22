class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final long MOD = 1_000_000_007L;
        int n = s.length();

        int[] idx = new int[n + 1];      // prefix count of non-zero digits
        long[] val = new long[n + 1];    // prefix concatenation (mod)
        long[] tot = new long[n + 1];    // prefix digit sum
        long[] pow10 = new long[n + 1];  // powers of 10

        pow10[0] = 1;
        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        int c = 0;

        // Build prefixes
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                c++;
                val[c] = (val[c - 1] * 10 + d) % MOD;
                tot[c] = tot[c - 1] + d;
            }
            idx[i + 1] = c;
        }

        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int a = idx[l];
            int b = idx[r + 1];

            if (a == b) {
                ans[i] = 0;
                continue;
            }

            int len = b - a;

            long num = (val[b] - (val[a] * pow10[len]) % MOD + MOD) % MOD;
            long sumDigits = tot[b] - tot[a];

            ans[i] = (int)((num * sumDigits) % MOD);
        }

        return ans;
    }
}
