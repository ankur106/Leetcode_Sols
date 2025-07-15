class Solution {
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;

        for(int i : nums){
            min = Math.min(min, i);
            maxDiff = Math.max(maxDiff, i - min);
        }

        return maxDiff == 0 ? -1 : maxDiff;
    }
}