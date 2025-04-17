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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        traverse(root, paths, targetSum, new ArrayList<Integer>());

        return paths;
    }

    private void traverse(TreeNode node, List<List<Integer>> paths, int targetSum, List<Integer> curr){
        if(node == null ) return;
        if(node.left == null && node.right == null && node.val == targetSum){
            curr.add(node.val);
            paths.add(new ArrayList<Integer>(curr));
            curr.remove(curr.size() - 1);
            return;
        }

        curr.add(node.val);
        traverse(node.left, paths, targetSum - node.val, curr);
        traverse(node.right, paths, targetSum - node.val, curr);
        curr.remove(curr.size()-1);        

    }
}