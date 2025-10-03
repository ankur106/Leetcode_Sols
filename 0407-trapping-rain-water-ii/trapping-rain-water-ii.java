class Solution {
    public int trapRainWater(int[][] heightMap) {

     if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;

        int n = heightMap.length;
        int m = heightMap[0].length;
        if (n < 3 || m < 3) return 0;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; ++i) {
            queue.offer(new int[]{heightMap[i][0], heightMap[i][0], i, 0});
            visited[i][0] = true;
            queue.offer(new int[]{heightMap[i][m - 1], heightMap[i][m - 1], i, m - 1});
            visited[i][m - 1] = true;
        }

        for (int j = 0; j < m; ++j) {
            if (!visited[0][j]) {
                queue.offer(new int[]{heightMap[0][j], heightMap[0][j], 0, j});
                visited[0][j] = true;
            }
            if (!visited[n - 1][j]) {
                queue.offer(new int[]{heightMap[n - 1][j], heightMap[n - 1][j], n - 1, j});
                visited[n - 1][j] = true;
            }
        }

        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{-1, 0, 1, 0};

        int water = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int currHeight = curr[0];
            int minHeight = curr[1];
            int x = curr[2];
            int y = curr[3];

            for (int dir = 0; dir < 4; ++dir) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (!isValid(nx, ny, n, m) || visited[nx][ny]) continue;

                visited[nx][ny] = true;

                int nh = heightMap[nx][ny];
                if (nh < minHeight) {
                    water += (minHeight - nh);
                }

                int nextMin = Math.max(minHeight, nh);
                queue.offer(new int[]{nh, nextMin, nx, ny});
            }
        }

        return water;
    }

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

}