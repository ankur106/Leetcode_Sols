/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<int[]>> columnTable = new TreeMap<>();
        dfs(root, 0, 0, columnTable);

        List<List<Integer>> result = new ArrayList<>();
        for (List<int[]> nodes : columnTable.values()) {
            nodes.sort((a, b) -> a[0] - b[0]);
            List<Integer> col = new ArrayList<>();
            for (int[] entry : nodes) {
                col.add(entry[1]);
            }
            result.add(col);
        }
        return result;
    }

    private void dfs(TreeNode node, int row, int col, Map<Integer, List<int[]>> table) {
        if (node == null) return;

        table.putIfAbsent(col, new ArrayList<>());
        table.get(col).add(new int[]{row, node.val});

        dfs(node.left, row + 1, col - 1, table);
        dfs(node.right, row + 1, col + 1, table);
    }
}