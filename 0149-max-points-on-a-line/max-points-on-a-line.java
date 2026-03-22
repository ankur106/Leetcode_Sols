
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int ans = 1;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dy = points[j][1] - points[i][1];
                int dx = points[j][0] - points[i][0];

                int g = gcd(dy, dx);
                dy /= g;
                dx /= g;

                // normalize sign
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = 1; // vertical line
                } else if (dy == 0) {
                    dx = 1; // horizontal line
                }

                String key = dy + "/" + dx;
                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);

                localMax = Math.max(localMax, count);
            }

            ans = Math.max(ans, localMax + 1); // +1 for anchor point
        }

        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }
}