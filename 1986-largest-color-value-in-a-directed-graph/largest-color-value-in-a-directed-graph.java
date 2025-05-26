class Solution {

    int max = Integer.MIN_VALUE;

    boolean hasCycle = false;

    public int largestPathValue(String colors, int[][] edges) {

        if(edges.length == 0 ) return 1;

        int n = colors.length();

        int[][] freq = new int[n][26];

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];


        Map<Integer, List<Integer>> adjList = new HashMap<>();

        char[] clrs = colors.toCharArray();

        for(int i=0;i < n ; ++i){
            adjList.put(i, new ArrayList<Integer>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
        }


        for(int i=0;i <n ; ++i){
            if(!visited[i]){
                dfs(i, adjList, visited, pathVisited, freq, clrs);
            }
        }


        return hasCycle ? -1 : max;

       
    }

    private void  dfs(int index, Map<Integer, List<Integer>> adjList, boolean[] visited, boolean[] pathVisited, int[][] freq, char[] clrs ){

        if(pathVisited[index]){
            hasCycle = true;
            return;
        }

        if(visited[index]) return;
        visited[index] = true;
        pathVisited[index] = true;

        int currClr = clrs[index] - 'a';
        freq[index][currClr] = 1;
        max = Math.max(max, freq[index][currClr]);

        for(int ngb : adjList.get(index)){
            dfs(ngb, adjList, visited, pathVisited, freq, clrs);

            for(int i=0; i < 26; ++i){

                int clr = freq[ngb][i];

                freq[index][i] = Math.max(freq[index][i] , i == currClr ? clr+1 : clr );

                max = Math.max(max, freq[index][i]);

            }
            
        }


        pathVisited[index] = false;


    }
}