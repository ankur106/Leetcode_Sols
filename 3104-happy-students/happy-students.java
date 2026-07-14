import java.util.Collections;
import java.util.List;

class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        
        int n = nums.size();
        int ways = 0;
        if (nums.get(0) > 0) {
            ways++;
        }

        for (int k = 1; k < n; k++) {
            if (nums.get(k - 1) < k && nums.get(k) > k) {
                ways++;
            }
        }
        
        if (nums.get(n - 1) < n) {
            ways++;
        }
        
        return ways;
    }
}