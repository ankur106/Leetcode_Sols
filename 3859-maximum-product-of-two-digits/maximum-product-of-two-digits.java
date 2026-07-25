class Solution {
    public int maxProduct(int n) {
        int[] arr = new int[10]; // To count digit frequencies

        while (n != 0) {
            arr[n % 10]++;
            n /= 10;
        }

        int first = -1;
        int second = -1;

        // Find the two largest distinct digits
        for (int i = 9; i >= 0; --i) {
            while (arr[i] > 0) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                    break; // Found both, exit loop early
                }
                arr[i]--;
            }
            if (second != -1) break;
        }

        // If we couldn't find two digits, return 0
        if (first == -1 || second == -1) return 0;

        return first * second;
    }
}