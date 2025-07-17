class Solution {
   
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        List<Integer> keyIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                keyIndices.add(i);
            }
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (idx < keyIndices.size() && keyIndices.get(idx) < i - k) {
                idx++;
            }

            if (idx < keyIndices.size() && Math.abs(i - keyIndices.get(idx)) <= k) {
                result.add(i);
            }
        }

        return result;
    }

}