import java.util.*;

class Solution {
    public int minNumberOfPrimes(int n, int m) {
        if (n == 0) return 0;

        List<Integer> primes = getFirstMPrimes(m);

        final int INF = n + 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        fill(dp, primes, 1, n);

        return dp[n] <= n ? dp[n] : -1;
    }

    private List<Integer> getFirstMPrimes(int m) {
        List<Integer> primes = new ArrayList<>(m);
        int candidate = 2;
        while (primes.size() < m) {
            if (isPrime(candidate)) {
                primes.add(candidate);
            }
            candidate++;
        }
        return primes;
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    private void fill(int[] dp, List<Integer> primes, int sum, int n) {
        if (sum > n) return;
        for (int p : primes) {
            if (p > sum) break;
            dp[sum] = Math.min(dp[sum], dp[sum - p] + 1);
        }
        fill(dp, primes, sum + 1, n);
    }
}