class Solution {

    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        // Step 1: Find distance of every cell from nearest thief
        int[][] distance = getDistanceFromThief(grid);

        // Step 2: Dijkstra
        // {safeness, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        int[][] best = new int[n][n];

        for (int[] row : best) {
            Arrays.fill(row, -1);
        }

        best[0][0] = distance[0][0];

        pq.offer(new int[]{
            distance[0][0],
            0,
            0
        });

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int currSafety = curr[0];
            int row = curr[1];
            int col = curr[2];

            // Ignore stale entry
            if (currSafety < best[row][col]) {
                continue;
            }

            if (row == n - 1 && col == n - 1) {
                return currSafety;
            }

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (
                    newRow < 0 ||
                    newRow >= n ||
                    newCol < 0 ||
                    newCol >= n
                ) {
                    continue;
                }

                // Minimum safeness seen on this path
                int newSafety = Math.min(
                    currSafety,
                    distance[newRow][newCol]
                );

                // Found a safer way to reach neighbor
                if (newSafety > best[newRow][newCol]) {

                    best[newRow][newCol] = newSafety;

                    pq.offer(new int[]{
                        newSafety,
                        newRow,
                        newCol
                    });
                }
            }
        }

        return 0;
    }


    private int[][] getDistanceFromThief(
        List<List<Integer>> grid
    ) {

        int n = grid.size();

        int[][] distance = new int[n][n];

        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();

        // Multi-source BFS:
        // add every thief initially
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (grid.get(row).get(col) == 1) {

                    distance[row][col] = 0;

                    queue.offer(new int[]{
                        row,
                        col
                    });
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (
                    newRow < 0 ||
                    newRow >= n ||
                    newCol < 0 ||
                    newCol >= n ||
                    distance[newRow][newCol] != -1
                ) {
                    continue;
                }

                distance[newRow][newCol] =
                    distance[row][col] + 1;

                queue.offer(new int[]{
                    newRow,
                    newCol
                });
            }
        }

        return distance;
    }
}