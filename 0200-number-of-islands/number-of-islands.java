class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Start DFS only from unvisited land
                if (grid[i][j] == '1' && !visited[i][j]) {
                    markCurrentIslandCell(grid, visited, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void markCurrentIslandCell(
        char[][] grid,
        boolean[][] visited,
        int x,
        int y
    ) {
        int n = grid.length;
        int m = grid[0].length;

        // Out of bounds
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }

        // Already visited or water
        if (visited[x][y] || grid[x][y] == '0') {
            return;
        }

        visited[x][y] = true;

        markCurrentIslandCell(grid, visited, x - 1, y); // up
        markCurrentIslandCell(grid, visited, x + 1, y); // down
        markCurrentIslandCell(grid, visited, x, y - 1); // left
        markCurrentIslandCell(grid, visited, x, y + 1); // right
    }
}