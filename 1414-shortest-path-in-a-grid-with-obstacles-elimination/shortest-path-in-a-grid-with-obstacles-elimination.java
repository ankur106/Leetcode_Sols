import java.util.*;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (k >= m + n - 2) return m + n - 2;

        int[][] maxK = new int[m][n];
        for (int[] row : maxK) Arrays.fill(row, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0, k});

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int steps = curr[0], x = curr[1], y = curr[2], rem = curr[3];

            if (x == m - 1 && y == n - 1) return steps;

            if (maxK[x][y] >= rem) continue; 
            maxK[x][y] = rem;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nextRem = rem - grid[nx][ny];
                    if (nextRem >= 0 && maxK[nx][ny] < nextRem) {
                        pq.offer(new int[]{steps + 1, nx, ny, nextRem});
                    }
                }
            }
        }

        return -1;
    }
}