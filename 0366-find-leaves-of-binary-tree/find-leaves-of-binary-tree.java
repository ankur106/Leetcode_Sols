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
    public List<List<Integer>> findLeaves(TreeNode root) {

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        List<List<Integer>> leaves = new ArrayList<>();
        
        dfs(root, map);
        for(Integer key: map.keySet()){
            leaves.add(map.get(key));
        }

        return leaves;
    }

    private int dfs(TreeNode node, TreeMap<Integer, List<Integer>> map){
        if(node == null) return 0;

        int left = dfs(node.left, map);
        int right = dfs(node.right, map);

        int level = 1 + Math.max(left, right);

        map.putIfAbsent(level, new ArrayList<Integer>());

        map.get(level).add(node.val);

        return level;
    }
}