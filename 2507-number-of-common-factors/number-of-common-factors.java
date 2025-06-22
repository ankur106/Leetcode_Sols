class Solution {
    public int commonFactors(int a, int b) {
        int g = gcd(a, b);
        int count = 0;

        for (int i = 1; i * i <= g; ++i) {
            if (g % i == 0) {
                count++; 
                if (i != g / i) count++; 
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}
}