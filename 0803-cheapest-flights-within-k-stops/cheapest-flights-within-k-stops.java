

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] flight : flights) {
            adjList.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        // minHeap: [cost, currentNode, stopsUsed]
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, src, -1});

        // visited map to avoid reprocessing worse costs with same or more stops
        Map<Integer, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];
            int stops = curr[2];

            if (node == dst) return cost;
            if (stops == k) continue;

            if (visited.containsKey(node) && visited.get(node) <= stops) {
                continue;
            }
            visited.put(node, stops);

            if (adjList.containsKey(node)) {
                for (int[] neighbor : adjList.get(node)) {
                    int nextNode = neighbor[0];
                    int price = neighbor[1];
                    pq.offer(new int[]{cost + price, nextNode, stops + 1});
                }
            }
        }

        return -1;
    }
}