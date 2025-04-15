class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = 10000000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canArriveOnTime(dist, hour, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canArriveOnTime(int[] dist, double hour, int speed) {
        double totalTime = 0.0;

        for (int i = 0; i < dist.length; i++) {
            double time = (double) dist[i] / speed;

            if (i != dist.length - 1) {
                totalTime += Math.ceil(time);
            } else {
                totalTime += time;
            }
        }

        return totalTime <= hour;
    }
}