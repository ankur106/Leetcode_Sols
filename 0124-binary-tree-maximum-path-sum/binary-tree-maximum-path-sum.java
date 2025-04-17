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
class Solution {
    public int maxPathSum(TreeNode root) {
        
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        dfs(root, maxSum);

        return maxSum[0];
    }

    private int dfs(TreeNode node, int[] maxSum){

        if(node == null) return 0;

        int left = dfs(node.left, maxSum);
        int right = dfs(node.right, maxSum);

        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        maxSum[0] = Math.max(maxSum[0], left + right + node.val);

        return Math.max(node.val + left, node.val + right);
    }
}