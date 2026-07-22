class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;      // largest single element — cap can't be smaller
        long high = 0;    // sum of all elements — cap never needs to be larger
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        long lo = low, hi = high;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (minPartitions(nums, mid) <= k) {
                hi = mid;          // cap works → try a tighter cap
            } else {
                lo = mid + 1;      // too many pieces → need a bigger cap
            }
        }
        return (int) lo;
    }

    private int minPartitions(int[] nums, long cap) {
        int pieces = 1;
        long currSum = 0;
        for (int num : nums) {
            if (currSum + num > cap) {
                pieces++;
                currSum = num;
            } else {
                currSum += num;
            }
        }
        return pieces;
    }
}