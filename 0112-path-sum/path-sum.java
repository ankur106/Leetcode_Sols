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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null) return false;

        for(int i : getPathSum(root) ){
            System.out.println(i);
            if(i==targetSum) return true;
        }

        return false;
        
    }


    private List<Integer> getPathSum(TreeNode node) {
        if(node ==null) return new ArrayList<Integer>();


        List<Integer> left = getPathSum(node.left);
        List<Integer> right = getPathSum(node.right);

        if(left.size()==0 && right.size()==0) return List.of(node.val);
        List<Integer> ans = new ArrayList<>();
        for(int i : left){
            ans.add(i + node.val);
        } 
        for(int i : right){
            ans.add(i + node.val);
        } 

        return ans;

    }
}