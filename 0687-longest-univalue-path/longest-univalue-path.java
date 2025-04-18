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

    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {

        dfs(root, Integer.MIN_VALUE);
        if(ans == 0) return 0;
        return ans -1;
        
    }

    private int dfs(TreeNode node, int parentVal){
        if(node == null) return 0; 

        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);

        ans = Math.max(ans, 1 + left + right);

        return node.val == parentVal ? Math.max(1+ left, 1+ right) : 0;
    }
}