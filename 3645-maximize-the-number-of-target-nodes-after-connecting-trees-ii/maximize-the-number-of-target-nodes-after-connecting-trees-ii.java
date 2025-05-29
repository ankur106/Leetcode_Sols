import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;

        List<List<Integer>> adj1 = buildAdjList(n1, edges1);
        List<List<Integer>> adj2 = buildAdjList(n2, edges2);

        // Bipartition Tree 1
        // nodeToPartitionMap1[i] = 0 if node i is in the first partition (e.g., even distance from BFS root)
        //                         = 1 if node i is in the second partition (e.g., odd distance from BFS root)
        // partitionSizes1[0/1] = size of the respective partition
        int[] nodeToPartitionMap1 = new int[n1];
        int[] partitionSizes1 = new int[2]; // {size of partition 0, size of partition 1}
        if (n1 > 0) {
            performBfsPartition(n1, adj1, nodeToPartitionMap1, partitionSizes1);
        }

        // Bipartition Tree 2
        int[] nodeToPartitionMap2 = new int[n2]; // Not strictly needed for final result but computed by BFS
        int[] partitionSizes2 = new int[2];
        if (n2 > 0) {
            performBfsPartition(n2, adj2, nodeToPartitionMap2, partitionSizes2);
        }

        // Calculate max contribution from Tree 2
        // This is max_j(t_odd_tree2[j]), where t_odd_tree2[j] is the number of nodes
        // in tree2 at an odd distance from node j.
        // If j is in partition P_A, t_odd_tree2[j] = size of P_B.
        // If j is in partition P_B, t_odd_tree2[j] = size of P_A.
        // So, max_j(t_odd_tree2[j]) is Math.max(size of P_A, size of P_B)
        // Special case: if tree2 has only 1 node, t_odd_tree2[j] is 0.
        int maxContributionFromTree2 = 0;
        if (n2 >= 2) { // If tree2 has at least 2 nodes, both partitions are non-empty
            maxContributionFromTree2 = Math.max(partitionSizes2[0], partitionSizes2[1]);
        } else { // n2 is 0 or 1
            maxContributionFromTree2 = 0; // If n2=1, t_odd_tree2[j]=0. If n2=0, contribution is 0.
        }
        
        int[] ans = new int[n1];
        if (n1 > 0) {
            for (int i = 0; i < n1; i++) {
                // t_even_tree1[i] = Number of nodes in tree1 at an even distance from node i.
                // This is the size of the partition that node 'i' belongs to.
                int tEvenTree1_i = partitionSizes1[nodeToPartitionMap1[i]];
                ans[i] = tEvenTree1_i + maxContributionFromTree2;
            }
        }
        return ans;
    }

    private List<List<Integer>> buildAdjList(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    private void performBfsPartition(int n, List<List<Integer>> adj, int[] nodeToPartitionMap, int[] partitionSizes) {
        Arrays.fill(nodeToPartitionMap, -1); // -1 indicates not visited
        Arrays.fill(partitionSizes, 0);

        Queue<Integer> q = new LinkedList<>();
        
        // Assuming node 0 exists and the tree is connected.
        // For disconnected components (not the case for a single tree), loop through all nodes.
        if (n == 0) return;

        q.offer(0); // Start BFS from node 0
        nodeToPartitionMap[0] = 0; // Node 0 is in partition 0 (representing even levels from start)
        partitionSizes[0]++;
        int currentLevel = 0;

        while (!q.isEmpty()) {
            int nodesInCurrentLevel = q.size();
            // Nodes processed in this level are in partition 'currentLevel % 2'
            // Their children will be in partition '(currentLevel + 1) % 2'
            int childPartition = (currentLevel + 1) % 2;

            for (int i = 0; i < nodesInCurrentLevel; i++) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (nodeToPartitionMap[v] == -1) { // If neighbor not visited
                        nodeToPartitionMap[v] = childPartition;
                        partitionSizes[childPartition]++;
                        q.offer(v);
                    }
                }
            }
            currentLevel++;
        }
    }
}