class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        int m = heights[0].length;

        int[][] effortTo = new int[n][m];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0] = 0;

        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        // [effort, x, y]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currEffort = curr[0];
            int x = curr[1];
            int y = curr[2];

            // If we've reached the destination, return the effort
            if (x == n - 1 && y == m - 1) {
                return currEffort;
            }

            for (int i = 0; i < 4; ++i) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (!isValid(newX, newY, n, m)) continue;

                int edgeEffort = Math.abs(heights[newX][newY] - heights[x][y]);
                int maxEffort = Math.max(currEffort, edgeEffort);

                if (effortTo[newX][newY] > maxEffort) {
                    effortTo[newX][newY] = maxEffort;
                    pq.offer(new int[]{maxEffort, newX, newY});
                }
            }
        }

        return 0; // Should never reach here
    }

    private boolean isValid(int x, int y, int n, int m) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}
