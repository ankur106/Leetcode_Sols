class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        int numSta = stations.length;
    
        double minDist = 0.0;
        double maxDist = stations[numSta - 1] - stations[0];

        while (maxDist - minDist > 1e-6) {
            double mid = (minDist + maxDist) / 2.0;
            if (numberOfStationsUsed(stations, mid) <= k) {
                maxDist = mid;
            } else {
                minDist = mid;
            }
        }

        return minDist;
    }

    int numberOfStationsUsed(int[] stations, double dist) {
        int count = 0;
        for (int i = 1; i < stations.length; ++i) {
            double d = stations[i] - stations[i - 1];
            count += (int)(d / dist);
        }
        return count;
    }
}