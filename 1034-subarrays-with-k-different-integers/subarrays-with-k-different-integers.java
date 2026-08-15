class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int currCount = 0;
        int totalCount = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add nums[right]
            map.put(nums[right],
                    map.getOrDefault(nums[right], 0) + 1);

            // k + 1 distinct numbers -> too many
            if (map.size() > k) {

                int num = nums[left];

                map.put(num, map.get(num) - 1);

                if (map.get(num) == 0) {
                    map.remove(num);
                }

                left++;

                // Previous possible starting positions no longer work
                currCount = 0;
            }

            // Exactly k distinct numbers
            if (map.size() == k) {

                // Remove unnecessary duplicates from the left
                while (map.get(nums[left]) > 1) {

                    int num = nums[left];

                    map.put(num, map.get(num) - 1);

                    left++;
                    currCount++;
                }

                totalCount += currCount + 1;
            }
        }

        return totalCount;
    }
}