class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();

        // Use n, not flights.length
        for (int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            adjList.get(from).add(new int[]{to, price});
        }

        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // node, price, flights used
        minHeap.offer(new int[]{src, 0, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            int currNode = curr[0];
            int currPrice = curr[1];
            int currSteps = curr[2];

            // k stops means at most k + 1 flights
            if (currSteps > k + 1) {
                continue;
            }

            // Since heap is ordered by price, first valid dst is cheapest
            if (currNode == dst) {
                return currPrice;
            }

            // We already reached this node using fewer flights
            if (currSteps >= steps[currNode]) {
                continue;
            }

            steps[currNode] = currSteps;

            // Cannot take another flight
            if (currSteps == k + 1) {
                continue;
            }

            for (int[] ngb : adjList.get(currNode)) {
                int ngbNode = ngb[0];
                int ngbPrice = ngb[1];

                minHeap.offer(new int[]{
                        ngbNode,
                        currPrice + ngbPrice,
                        currSteps + 1
                });
            }
        }

        return -1;
    }
}