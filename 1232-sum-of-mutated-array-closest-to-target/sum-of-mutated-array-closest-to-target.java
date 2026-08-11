class Solution {
    public int findBestValue(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxValue = 0;

        // No useful answer needs to be greater than the largest element.
        for (int number : arr) {
            maxValue = Math.max(maxValue, number);
        }

        int left = 0;
        int right = maxValue;

        // Find the smallest value whose mutated sum is >= target.
        while (left < right) {
            int mid = left + (right - left) / 2;
            long sum = mutatedSum(arr, mid);

            if (sum < target) {
                // The current value makes the sum too small,
                // so a larger mutation value is required.
                left = mid + 1;
            } else {
                // Mid may be the first value reaching the target.
                right = mid;
            }
        }

        int higherValue = left;
        int lowerValue = Math.max(0, higherValue - 1);

        long higherDifference =
                Math.abs(mutatedSum(arr, higherValue) - target);
        long lowerDifference =
                Math.abs(mutatedSum(arr, lowerValue) - target);

        // Returning lowerValue on equality satisfies the tie rule.
        if (lowerDifference <= higherDifference) {
            return lowerValue;
        }

        return higherValue;
    }

    private long mutatedSum(int[] arr, int value) {
        long sum = 0;

        // Every number greater than value is replaced by value.
        for (int number : arr) {
            sum += Math.min(number, value);
        }

        return sum;
    }
}