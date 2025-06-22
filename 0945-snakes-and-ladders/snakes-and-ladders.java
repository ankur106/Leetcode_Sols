import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) return moves;

                for (int dice = 1; dice <= 6 && curr + dice <= n * n; dice++) {
                    int next = curr + dice;
                    int[] pos = getCoordinates(next, n);
                    int val = board[pos[0]][pos[1]];

                    if (val != -1) next = val;

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private int[] getCoordinates(int num, int n) {
        int row = (num - 1) / n;
        int col = (num - 1) % n;
        int x = n - 1 - row;
        int y = (row % 2 == 0) ? col : n - 1 - col;
        return new int[]{x, y};
    }
}