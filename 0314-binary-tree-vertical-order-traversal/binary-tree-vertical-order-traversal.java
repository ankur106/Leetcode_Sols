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
    class NodeInfo {
        TreeNode node;
        int col;
        NodeInfo(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        Queue<NodeInfo> queue = new LinkedList<>();

        int minCol = 0, maxCol = 0;

        queue.offer(new NodeInfo(root, 0));

        while (!queue.isEmpty()) {
            NodeInfo info = queue.poll();
            TreeNode node = info.node;
            int col = info.col;

            columnTable.putIfAbsent(col, new ArrayList<>());
            columnTable.get(col).add(node.val);

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if (node.left != null)
                queue.offer(new NodeInfo(node.left, col - 1));
            if (node.right != null)
                queue.offer(new NodeInfo(node.right, col + 1));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            result.add(columnTable.get(i));
        }

        return result;
    }
}
