import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<Integer>[] li1 = new ArrayList[n];
        List<Integer>[] li2 = new ArrayList[m];

        for (int i = 0; i < n; ++i) {
            li1[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; ++i) {
            li2[i] = new ArrayList<Integer>();
        }

        for (int[] edge : edges1) {
            li1[edge[0]].add(edge[1]);
            li1[edge[1]].add(edge[0]);
        }

        for (int[] edge : edges2) {
            li2[edge[0]].add(edge[1]);
            li2[edge[1]].add(edge[0]);
        }

        // arr[i][0] will store total nodes at ODD distance from node i
        // arr[i][1] will store total nodes at EVEN distance from node i
        int[][] arr1 = new int[n][2];
        int[] disFromRoot1 = new int[n]; // Kept as per original structure

        int[][] arr2 = new int[m][2];
        int[] disFromRoot2 = new int[m]; // Kept as per original structure

        // First DFS: Calculate subtree counts and distances from root 0
        if (n > 0) { // Check to prevent issues if n could be 0 based on input, though problem implies n,m >=1
            dfs(li1, -1, 0, arr1, disFromRoot1, 0);
            backTrack(li1, -1, 0, arr1, disFromRoot1);
        }
        
        if (m > 0) { // Check to prevent issues if m could be 0
            dfs(li2, -1, 0, arr2, disFromRoot2, 0);
            backTrack(li2, -1, 0, arr2, disFromRoot2);
        }

        int maxOddCountInTree2 = 0;
        if (m > 0) { // Ensure there are nodes in tree2
            // If m=1, arr2[0][0] (odd count) is 0. Initialize max to 0 is safe.
            for (int i = 0; i < m; ++i) {
                maxOddCountInTree2 = Math.max(maxOddCountInTree2, arr2[i][0]);
            }
        }

        int[] ans = new int[n];
         if (n > 0) {
            for (int i = 0; i < n; ++i) {
                ans[i] = arr1[i][1] + maxOddCountInTree2;
            }
        }

        return ans;
    }

    /**
     * Calculates subtree counts and distance from root (node 0).
     * paths[index][0]: count of nodes in subtree of 'index' at ODD distance from 'index'.
     * paths[index][1]: count of nodes in subtree of 'index' at EVEN distance from 'index'.
     */
    private void dfs(List<Integer>[] adjList, int parent, int index, int[][] paths, int[] disFromRoot, int dis) {
        disFromRoot[index] = dis;

        paths[index][1] = 1; // Node 'index' is at 0 (even) distance from itself.
        paths[index][0] = 0; // Initialize odd count for current node's subtree.

        for (int neighbor : adjList[index]) {
            if (neighbor == parent) continue;

            dfs(adjList, index, neighbor, paths, disFromRoot, dis + 1);

            // Nodes in neighbor's subtree that are EVEN from neighbor will be ODD from index.
            paths[index][0] += paths[neighbor][1];
            // Nodes in neighbor's subtree that are ODD from neighbor will be EVEN from index.
            paths[index][1] += paths[neighbor][0];
        }
    }

    /**
     * Corrected backTrack: Calculates total counts for each node using rerooting.
     * paths[u][0] (on entry: s_odd[u]) becomes t_odd[u] (total odd from u).
     * paths[u][1] (on entry: s_even[u]) becomes t_even[u] (total even from u).
     * disFromRoot is passed to maintain signature but not used in the corrected logic.
     */
    private void backTrack(List<Integer>[] adjList, int parentOfIndex, int index, int[][] paths, int[] disFromRoot) {
        // On entry:
        // paths[index][0] is s_odd[index] (subtree odd count from index)
        // paths[index][1] is s_even[index] (subtree even count from index)
        // If parentOfIndex != -1:
        // paths[parentOfIndex][0] is t_odd[parentOfIndex] (total odd from parent)
        // paths[parentOfIndex][1] is t_even[parentOfIndex] (total even from parent)

        if (parentOfIndex != -1) {
            // Contribution from parent's branch to 'index's EVEN count:
            // These are nodes that were ODD distance from parentOfIndex (globally),
            // excluding those nodes that were in 'index's subtree (which are s_even[index] for 'index',
            // and thus odd from parentOfIndex, hence already counted in paths[parentOfIndex][0]).
            int parentBranchEvenToIndex = paths[parentOfIndex][0] - paths[index][1];

            // Contribution from parent's branch to 'index's ODD count:
            // These are nodes that were EVEN distance from parentOfIndex (globally),
            // excluding those nodes that were in 'index's subtree (which are s_odd[index] for 'index',
            // and thus even from parentOfIndex, hence already counted in paths[parentOfIndex][1]).
            int parentBranchOddToIndex = paths[parentOfIndex][1] - paths[index][0];

            // Add these "up-contributions" to the existing subtree counts for 'index'
            paths[index][1] += parentBranchEvenToIndex; // paths[index][1] now becomes t_even[index]
            paths[index][0] += parentBranchOddToIndex;  // paths[index][0] now becomes t_odd[index]
        }
        // If parentOfIndex == -1, 'index' is the root of this DFS (e.g., node 0).
        // Its paths array, as computed by the first 'dfs' call, already represents total counts.

        // Now paths[index][0] and paths[index][1] are total counts for node 'index'.
        // Recursively call for neighbors (children in this DFS traversal).
        for (int ngb : adjList[index]) {
            if (ngb == parentOfIndex) continue;
            // When calling for ngb:
            // - 'index' is the parentOfIndex for 'ngb'.
            // - paths[index] now correctly holds total counts for 'index'.
            // - paths[ngb] still holds subtree counts for 'ngb'; the recursive call will update it.
            backTrack(adjList, index, ngb, paths, disFromRoot);
        }
    }
}