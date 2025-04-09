public class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // Initialize adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list with edges
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        // BFS initialization
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int curTime = 0;
        int res = -1;
        
        // Initialize visit times for each node
        List<List<Integer>> visitTimes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            visitTimes.add(new ArrayList<>());
        }
        visitTimes.get(1).add(0);

        // BFS traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int node = queue.poll();

                // Check if we've reached the destination node
                if (node == n) {
                    if (res != -1) return curTime;
                    res = curTime;
                }

                // Explore neighbors
                for (int nei : adj.get(node)) {
                    List<Integer> neiTimes = visitTimes.get(nei);

                    // Check if the neighbor can be visited
                    if (neiTimes.isEmpty() || (neiTimes.size() == 1 && !neiTimes.contains(curTime))) {
                        queue.offer(nei);
                        neiTimes.add(curTime);
                    }
                }
            }

            // Handle traffic signals (wait for green light if needed)
            if ((curTime / change) % 2 == 1) {
                curTime += change - (curTime % change);
            }

            // Increase current time by the edge traversal time
            curTime += time;
        }

        return -1; // Return -1 if the second minimum path is not found
    }
}