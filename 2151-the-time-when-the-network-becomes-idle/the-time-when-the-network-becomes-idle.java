class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        
        int n = patience.length;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        // Standard BFS for shortest path
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        minDist[0] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    minDist[neighbor] = minDist[curr] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i < n; ++i) {
            int roundTripTime = 2 * minDist[i];

            int lastTimeSent = 0;
            if (patience[i] < roundTripTime) {
                lastTimeSent = ((roundTripTime - 1) / patience[i]) * patience[i];
            }

            int timeWhenIdle = lastTimeSent + roundTripTime;
            maxTime = Math.max(maxTime, timeWhenIdle);
        }

        return maxTime + 1; // Add 1 since the network becomes idle *after* the last reply arrives
    }
}