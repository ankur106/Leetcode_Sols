class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> ans = new HashSet<>();
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] visiting = new boolean[n]; // track current DFS stack for cycle detection

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(graph, visited, visiting, ans, i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>(ans);
        Collections.sort(result);
        return result;
    }

    private boolean dfs(int[][] graph, boolean[] visited, boolean[] visiting, Set<Integer> ans, int node) {
        if (visiting[node]) return false; 
        if (visited[node]) return ans.contains(node); 

        visiting[node] = true;
        visited[node] = true;

        for (int neighbor : graph[node]) {
            if (!dfs(graph, visited, visiting, ans, neighbor)) {
                visiting[node] = false; 
                return false;
            }
        }

        visiting[node] = false;
        ans.add(node); 
        return true;
    }
}