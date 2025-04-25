import java.math.BigInteger; // Can use long with careful modulo arithmetic too

class Solution {
    // Define constants for Rabin-Karp
    // Using long and manual modulo to avoid BigInteger overhead if preferred
    private static final long BASE = 31; // A prime base (often used for lowercase letters)
    private static final long MOD = 1_000_000_007; // A large prime modulus

    /**
     * Computes (base^exp) % mod efficiently using modular exponentiation.
     */
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    /**
     * Searches for the 'pattern' string within the 'text' string using Rabin-Karp.
     * Returns true if the pattern is found, false otherwise.
     */
    private boolean rabinKarpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m == 0) return true;   // Empty pattern is always considered found
        if (n < m) return false;  // Text is shorter than pattern

        // Precompute BASE^(m-1) % MOD for rolling hash calculation
        long P_POW_M_MINUS_1 = power(BASE, m - 1);

        // Calculate hash for the pattern and the first window of the text
        long patternHash = 0;
        long textWindowHash = 0;
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * BASE + pattern.charAt(i)) % MOD;
            textWindowHash = (textWindowHash * BASE + text.charAt(i)) % MOD;
        }

        // Slide the window across the text
        for (int i = 0; i <= n - m; i++) {
            // Check if the hash values match
            if (patternHash == textWindowHash) {
                // If hashes match, perform a character-by-character comparison
                // to rule out collisions.
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true; // Pattern found
                }
                // If hashes matched but strings didn't, it was a collision. Continue searching.
            }

            // Calculate the hash for the next window using the rolling hash technique
            if (i < n - m) {
                // 1. Remove the contribution of the leading character
                long leadingCharValue = (text.charAt(i) * P_POW_M_MINUS_1) % MOD;
                textWindowHash = (textWindowHash - leadingCharValue + MOD) % MOD; // Add MOD to handle potential negative result

                // 2. Shift the hash one position to the left (multiply by BASE)
                textWindowHash = (textWindowHash * BASE) % MOD;

                // 3. Add the contribution of the new trailing character
                textWindowHash = (textWindowHash + text.charAt(i + m)) % MOD;
            }
        }

        return false; // Pattern not found after checking all windows
    }

    /**
     * Finds the minimum number of times string 'a' must be repeated such that
     * string 'b' is a substring of the repeated string. Uses Rabin-Karp for searching.
     */
    public int repeatedStringMatch(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        if (aLen == 0 && bLen == 0) return 1; // Or 0 depending on interpretation
        if (aLen == 0) return -1; // Cannot form non-empty b from empty a

        // Calculate minimum repeats needed for length >= bLen
        // We need at least enough 'a's to cover the length of 'b'.
        int minRepeats = (int) Math.ceil((double) bLen / aLen);

        // Use StringBuilder for efficient string concatenation
        StringBuilder sBuilder1 = new StringBuilder();
        for (int i = 0; i < minRepeats; i++) {
            sBuilder1.append(a);
        }
        String s1 = sBuilder1.toString();

        // Check if b is a substring of a repeated minRepeats times using Rabin-Karp
        if (rabinKarpSearch(s1, b)) {
            return minRepeats;
        }

        // If not found, try repeating one more time. This covers cases where 'b'
        // might span across the boundary of two concatenated 'a's.
        // Append 'a' to the existing StringBuilder
        sBuilder1.append(a);
        String s2 = sBuilder1.toString();

        // Check if b is a substring of a repeated (minRepeats + 1) times using Rabin-Karp
        if (rabinKarpSearch(s2, b)) {
            return minRepeats + 1;
        }

        // If not found in either case, it's impossible
        return -1;
    }
}