class Solution {
    public int maxFrequency(int[] nums, int k) {
        final int MAX = 50;
        int base = 0;
        for (int num : nums) {
            if (num == k) base++;
        }

        int maxGain = 0;
        for (int v = 1; v <= MAX; v++) {
            if (v == k) continue;
            int gain = 0, best = 0;
            for (int num : nums) {
                if (num == v) {
                    gain++;
                } else if (num == k) {
                    gain--;
                }
                if (gain < 0) gain = 0;
                best = Math.max(best, gain);
            }
            maxGain = Math.max(maxGain, best);
        }

        return base + maxGain;
    }
}