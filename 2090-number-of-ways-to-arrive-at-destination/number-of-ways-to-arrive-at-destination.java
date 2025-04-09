class Solution {
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] curr : roads){
            adj.putIfAbsent(curr[0], new ArrayList<int[]>());
            adj.putIfAbsent(curr[1], new ArrayList<int[]>());
            adj.get(curr[0]).add(new int[] {curr[1], curr[2]});
            adj.get(curr[1]).add(new int[] {curr[0], curr[2]});
        }

        int[] ways = new int[n];
        Arrays.fill(ways, 0);
        ways[0]= 1;

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0]= 0;

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0,0});


        while(!pq.isEmpty()){

            int curr[] = pq.poll();

            int wht = curr[0];
            int node = curr[1];

            if(node == n-1) return ways[n-1];

            if(adj.containsKey(node)){
                for(int next[] : adj.get(node)){
                if(wht + next[1] < cost[next[0]]) {
                    cost[next[0]] = wht + next[1];
                    ways[next[0]] = ways[node];
                    pq.offer(new int[]{cost[next[0]], next[0]});
                }else if(wht + next[1] == cost[next[0]]){
                    ways[next[0]] = (ways[next[0]] + ways[node]) % 1000000007;
                }

            }
            }
            



        }

        return 0;
    }
}