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
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            //go as left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            //visit
            curr = stack.pop();
            ans.add(curr.val);
            

            //go right
            curr = curr.right;
        }
        // traverse(root, ans);
        return ans;
    }

    private void traverse(TreeNode node, List<Integer> ans){
        if(node == null) return;
        traverse(node.left, ans);

        ans.add(node.val);
        traverse(node.right, ans);

    }
}