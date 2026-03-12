class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int provinces = 0;

        for(int i = 0; i<n; ++i ){
            if(visited[i]) continue;
            provinces++;

            Queue<Integer> que = new LinkedList<>();
            que.offer(i);

            while(que.size() > 0){
                int curr = que.poll();
                visited[curr] = true;

                for(int j = 0; j< n; ++j){
                    if(isConnected[curr][j] == 1 && !visited[j]) que.offer(j);
                }
            }
        }
        return provinces;
    }
}