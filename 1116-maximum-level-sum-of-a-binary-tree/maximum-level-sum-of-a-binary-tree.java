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
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();

        dfs(root, map, 1);
        
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> ent : map.entrySet()){
            if(ent.getValue() > maxSum){
                maxSum = ent.getValue();
                maxLevel = ent.getKey();
            }
        }

        return maxLevel;
    }


    private void dfs(TreeNode node, Map<Integer, Integer> map, int level ){
        if(node == null) return;

        map.put(level, map.getOrDefault(level, 0) + node.val);
        dfs(node.left, map, level + 1);
        dfs(node.right, map, level + 1);

    }
}