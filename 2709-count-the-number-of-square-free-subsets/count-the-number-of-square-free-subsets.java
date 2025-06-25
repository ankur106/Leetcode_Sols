class Solution {
    public int squareFreeSubsets(int[] nums) {
        int MOD = (int)1e9 + 7;

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        Map<Integer, Integer> numMask = new HashMap<>();

        // Precompute square-free numbers <= 30 and their prime bitmask
        for (int num = 2; num <= 30; num++) {
            int x = num, mask = 0;
            boolean squareFree = true;
            for (int i = 0; i < primes.length; i++) {
                int cnt = 0;
                while (x % primes[i] == 0) {
                    x /= primes[i];
                    cnt++;
                }
                if (cnt > 1) {
                    squareFree = false;
                    break;
                }
                if (cnt == 1) mask |= (1 << i);
            }
            if (squareFree && x == 1) numMask.put(num, mask);
        }

        // Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        long[] dp = new long[1 << 10];
        dp[0] = 1;

        for (int num : freq.keySet()) {
            if (num == 1 || !numMask.containsKey(num)) continue;
            int count = freq.get(num);
            int bitmask = numMask.get(num);
            for (int mask = (1 << 10) - 1; mask >= 0; mask--) {
                if ((mask & bitmask) == 0) {
                    dp[mask | bitmask] = (dp[mask | bitmask] + dp[mask] * count) % MOD;
                }
            }
        }

        long result = 0;
        for (int i = 1; i < (1 << 10); i++) {
            result = (result + dp[i]) % MOD;
        }

        int ones = freq.getOrDefault(1, 0);
        long pow2 = 1;
        for (int i = 0; i < ones; i++) {
            pow2 = (pow2 * 2) % MOD;
        }

        return (int)((result * pow2 + pow2 - 1) % MOD);
        
    }
}