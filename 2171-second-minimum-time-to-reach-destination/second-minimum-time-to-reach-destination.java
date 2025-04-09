public class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // Build graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Queue stores [node, current time]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});

        // For each node, store unique arrival times (max 2 times per node)
        List<List<Integer>> visitTimes = new ArrayList<>();
        for (int i = 0; i <= n; i++) visitTimes.add(new ArrayList<>());
        visitTimes.get(1).add(0);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int curTime = current[1];

            for (int neighbor : adj.get(node)) {
                int nextTime = curTime;

                // Wait for green light if needed
                if ((nextTime / change) % 2 == 1) {
                    nextTime += change - (nextTime % change);
                }

                // Add edge traversal time
                nextTime += time;

                List<Integer> times = visitTimes.get(neighbor);
                if (times.size() < 2 && !times.contains(nextTime)) {
                    times.add(nextTime);
                    queue.offer(new int[]{neighbor, nextTime});

                    // If we've reached target twice, return the second time
                    if (neighbor == n && times.size() == 2) {
                        return nextTime;
                    }
                }
            }
        }

        return -1;
    }
}