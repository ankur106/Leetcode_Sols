class Solution {

    private boolean[] populatePrime(int n){
    boolean[] primes = new boolean[n];
    Arrays.fill(primes, true);
    if (n > 0) primes[0] = false;
    if (n > 1) primes[1] = false;

    for(int i = 2; i * i < n; ++i){
        if(primes[i]){
            for(int j = i * i; j < n; j += i){
                primes[j] = false;
            }
        }
    }
    return primes;
}

    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean[] primes = populatePrime(n);

        int count = 0;

        for(boolean prime : primes){
            if(prime)count++;
        }
        return count;
    }
}