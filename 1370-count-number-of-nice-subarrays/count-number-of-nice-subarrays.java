class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
    int res = 0, odd = 0, gap = 0, l = 0;
    for (int r = 0; r < nums.length; r++) {
        if (nums[r] % 2 == 1) { odd++; gap = 0; }   // new odd → recount
        while (odd == k) {
            odd -= nums[l++] % 2;
            gap++;                                   // valid left starts
        }
        res += gap;
    }
    return res;
}
}