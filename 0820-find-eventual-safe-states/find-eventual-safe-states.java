class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        int[] traverse = new int[len]; // 0 -> not visited, 1 -> visiting, 2 -> visited

        List<Integer> safeStates = new ArrayList<>();
        for(int i = 0; i < len; ++i){
            if(traverse[i] == 0){
                dfs(graph, safeStates, i, traverse);
            }
        }
        Collections.sort(safeStates);
        return safeStates;
    }


    private boolean dfs(int[][] graph, List<Integer> safeStates, int node, int[] traverse){
        if(traverse[node] == 2) return true;
        if(traverse[node] == 1) return false; // cycle found

        traverse[node] = 1;
        for(int ngb : graph[node]){
            if(!dfs(graph, safeStates, ngb, traverse)){
                return false;
            }
        }

        safeStates.add(node);
        traverse[node] = 2;
        return true;
    }
}