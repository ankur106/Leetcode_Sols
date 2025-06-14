import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        // Build map from value → list of all indices with that value
        Map<Integer, List<Integer>> idxOf = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxOf
              .computeIfAbsent(arr[i], k -> new ArrayList<>())
              .add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;

        int steps = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int k = 0; k < sz; k++) {
                int i = q.poll();
                if (i == n - 1) {
                    return steps;
                }

                List<Integer> same = idxOf.get(arr[i]);
                if (same != null) {
                    for (int j : same) {
                        if (!visited[j]) {
                            visited[j] = true;
                            q.offer(j);
                        }
                    }
                    same.clear();
                }

                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }
            }
            steps++;
        }

        return -1;
    }
}