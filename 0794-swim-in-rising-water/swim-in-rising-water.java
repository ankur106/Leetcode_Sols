class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;

        boolean visited[][] = new boolean[n][n];

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        pq.offer(new int[]{grid[0][0],0,0});
        int dx[]= new int[]{0, -1, 0, 1};
        int dy[] = new int[]{-1, 0, 1, 0};

        int max = 0;

        while(!pq.isEmpty()){

            int curr[] = pq.poll();
            visited[curr[1]][curr[2]] = true;

            max = Math.max(max, curr[0]);

            if(curr[1] == n-1 && curr[2] == n-1) return max;

            for(int i=0; i < 4; ++i){
                int adjX = curr[1] + dx[i];
               int adjY = curr[2] + dy[i];

               if(isValid(adjX, adjY, n) && !visited[adjX][adjY]){
                    pq.offer(new int[]{grid[adjX][adjY], adjX, adjY});
               }
            }
        }

        return -1;
        
    }

    private boolean isValid(int i, int j, int n){
        return i >=0 && i < n && j >=0 && j < n;
    }
}