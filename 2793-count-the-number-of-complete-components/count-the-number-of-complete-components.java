import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Create adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());  // Ensure all nodes exist
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        // Traverse all nodes to find connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] nodeEdges = new int[2];  // [0] = numNodes, [1] = numEdges
                dfs(adjList, visited, i, nodeEdges);

                // Each edge was counted twice, so divide by 2
                nodeEdges[1] /= 2;

                // Check if it's a complete graph
                if (nodeEdges[1] == (nodeEdges[0] * (nodeEdges[0] - 1)) / 2) {
                    completeComponents++;
                }
            }
        }
        return completeComponents;
    }

    private void dfs(Map<Integer, List<Integer>> adjList, boolean[] visited, int node, int[] nodeEdges) {
        visited[node] = true;
        nodeEdges[0]++; // Count nodes in the component
        nodeEdges[1] += adjList.get(node).size(); // Count edges (each counted twice)

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(adjList, visited, neighbor, nodeEdges);
            }
        }
    }
}