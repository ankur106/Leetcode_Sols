import java.util.*;

class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        PriorityQueue<Integer> deltaQueue = new PriorityQueue<>();
        for (int num : nums) {
            int xored = num ^ k;
            int delta = xored - num;
            deltaQueue.offer(delta);
            totalSum += num; 
        }


        long netChange = 0;
        List<Integer> deltas = new ArrayList<>(deltaQueue);
        Collections.sort(deltas, Collections.reverseOrder());

        for (int i = 0; i + 1 < deltas.size(); i += 2) {
            int pairSum = deltas.get(i) + deltas.get(i + 1);
            if (pairSum > 0) {
                netChange += pairSum; 
            } else {
                break;
            }
        }

        return totalSum + netChange;
    }
}