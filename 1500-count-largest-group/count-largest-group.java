class Solution {
    public int countLargestGroup(int n) {
    int[] count = new int[37]; // max digit sum is 36

    for (int i = 0; i <= n; i += 10) {
        int sum = getDigitSum(i);
        for (int j = 0; j < 10 && (i + j) <= n; ++j) {
            count[sum + j]++;
        }
    }
    count[0]--;
    int max = 0;
    for (int c : count) {
        if (c > max) max = c;
    }

    int res = 0;
    for (int c : count) {
        if (c == max) res++;
    }

    return res;
}

    private int getDigitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}