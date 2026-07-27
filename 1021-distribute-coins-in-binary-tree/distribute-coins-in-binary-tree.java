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
    int ans;
    public int distributeCoins(TreeNode root) {
        this.ans = 0;
        dfs(root);
        return ans;
    }
    private int[] dfs(TreeNode node){
        if(node == null) return new int[]{0, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int coinsNeeded = left[0] + right[0] + 1;
        int coinsAvailable = left[1] + right[1] + node.val;

        this.ans += Math.abs(coinsNeeded - coinsAvailable);
        return new int[]{coinsNeeded, coinsAvailable}; 
    }
}