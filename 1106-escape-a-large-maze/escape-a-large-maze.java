import java.util.*;

class Solution {

    int dx[] = new int[]{0, -1, 0, 1};
    int dy[] = new int[]{-1, 0, 1, 0};

    static final int BOUND = 20000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] block : blocked) {
            blockedSet.add(block[0] + "," + block[1]);
        }

        boolean check1 = check(source[0], source[1], target, new HashSet<>(blockedSet));
        boolean check2 = check(target[0], target[1], source, new HashSet<>(blockedSet));

        return check1 && check2;
    }

    private boolean check(int x, int y, int[] target, Set<String> visited) {
        return dfs(x, y, target, visited, 0);
    }

    private boolean dfs(int x, int y, int[] target, Set<String> visited, int count) {
        String key = x + "," + y;
        if (visited.contains(key) || x < 0 || y < 0 || x >= 1_000_000 || y >= 1_000_000) return false;

        visited.add(key);
        count++;

        if (x == target[0] && y == target[1]) return true;
        if (count > BOUND) return true;

        for (int i = 0; i < 4; ++i) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (dfs(newX, newY, target, visited, count)) return true;
        }

        return false;
    }
}