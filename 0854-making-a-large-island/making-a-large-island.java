class DSU {
    
    int[] parent;
    int[] size;
    DSU(int n){
        parent = new int[n];
        size = new int[n];

        for(int i=0; i < n; ++i){
            parent[i] = i;
        }
        Arrays.fill(size, 1);
    }

    public int findParent(int node){

        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }   

    public void union(int n1, int n2){
        int p1= findParent(n1);
        int p2 = findParent(n2);

        if(p1 == p2 ) return;

        if(size[p1] < size[p2]){
            parent[p1] = p2;
            size[p2] += size[p1];
        }else{
            parent[p2] = p1;
            size[p1] += size[p2];
        }
    }

    public int getSize(int node){
        return size[node];
    }

    


}


class Solution {

    private boolean isValid(int i, int j, int n, int m) {
        return i >=0 && i < n && j >=0 && j < m;
    }


    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;  

        boolean visited[][] = new boolean[n][m];

        DSU dsu = new DSU(n*m);
        int dx[] = new int[]{0, -1, 0, 1};
        int dy[] = new int[]{-1, 0, 1, 0}; 

        for(int i=0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(grid[i][j]==0) continue;

                for(int k=0; k < 4; k++){
                    int adjX = i + dx[k];
                    int adjY = j + dy[k];

                    if(isValid(adjX, adjY, n , m) && grid[adjX][adjY] == 1){
                        int curr = i * m + j;
                        int adj = adjX * m + adjY;

                        if(dsu.findParent(curr) != dsu.findParent(adj)) {
                            dsu.union(curr,adj);
                        }
                    }
                } 

            }
        }
        int ans = 0;
        for(int i=0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(grid[i][j]==1) continue;

                    Set<Integer> neighborParents = new HashSet<>();
                    int totalSize = 0;
                    for(int k = 0; k < 4; ++k) {
                        int adjX = i + dx[k];
                        int adjY = j + dy[k];
                        if (isValid(adjX, adjY, n, m) && grid[adjX][adjY] == 1) {
                            int adj = adjX * m + adjY;
                            int parent = dsu.findParent(adj);
                            if (neighborParents.add(parent)) {
                                totalSize += dsu.getSize(parent);
                            }
                        }
                    }
                    ans = Math.max(ans, 1 + totalSize);

            }
        }

        for(int i = 0; i < n * m; i++) {
            ans = Math.max(ans, dsu.getSize(dsu.findParent(i)));}


        return ans;

    }
}