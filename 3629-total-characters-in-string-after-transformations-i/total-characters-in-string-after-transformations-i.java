class Solution {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        long[] freq = new long[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            long[] nextFreq = new long[26];
            for (int j = 0; j < 26; j++) {
                if (j == 25) {
                    nextFreq[0] = (nextFreq[0] + freq[j]) % MOD;
                    nextFreq[1] = (nextFreq[1] + freq[j]) % MOD;
                } else {
                    nextFreq[j + 1] = (nextFreq[j + 1] + freq[j]) % MOD;
                }
            }
            freq = nextFreq;
        }

        long total = 0;
        for (int i = 0; i < 26; i++) {
            total = (total + freq[i]) % MOD;
        }

        return (int) total;
    }
}