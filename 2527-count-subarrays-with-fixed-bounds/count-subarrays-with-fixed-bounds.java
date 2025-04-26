class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0L;
        int minKIndex = -1; // Index of the most recent minK
        int maxKIndex = -1; // Index of the most recent maxK
        int leftBound = -1; // Index of the most recent element violating bounds [minK, maxK]

        for (int i = 0; i < nums.length; ++i) {
            int currentNum = nums[i];

            // Check if the current number is outside the desired range
            if (currentNum < minK || currentNum > maxK) {
                leftBound = i; // This index cannot be part of any valid subarray further on
                // minKIndex and maxKIndex before this point are now irrelevant
                // for subarrays ending at or after i, because those subarrays
                // must start *after* leftBound.
            }

            // Update the latest indices where minK and maxK were seen
            if (currentNum == minK) {
                minKIndex = i;
            }
            if (currentNum == maxK) {
                maxKIndex = i;
            }

            // Determine the number of valid subarrays ending at index i.
            // A valid subarray must start *after* leftBound.
            // It must also start at or before both minKIndex and maxKIndex
            // to ensure both minK and maxK are included.
            // Therefore, the latest valid start index is min(minKIndex, maxKIndex).
            // The number of valid start indices j is the number of integers such that:
            // leftBound < j <= min(minKIndex, maxKIndex)

            int earliestRequiredStart = Math.min(minKIndex, maxKIndex);

            // If earliestRequiredStart is less than or equal to leftBound,
            // it means either we haven't seen both minK and maxK yet,
            // or the last time we saw one of them was before the last
            // out-of-bounds element. In either case, no valid subarray ends at i.
            long count = Math.max(0L, (long)earliestRequiredStart - leftBound);

            ans += count;
        }

        return ans;
    }
}