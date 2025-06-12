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
    public int kthSmallest(TreeNode root, int k) {


        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();


            result.add(current.val);

            if(result.size() ==k) break;
            current = current.right;
        }
        return result.get(result.size() - 1);
        // List<Integer> li = new ArrayList<>();

        // inOrderTraversal(root, li);

        // return li.get(k-1);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> li){
        if(node == null) return;

        inOrderTraversal(node.left, li);
        li.add(node.val);
        inOrderTraversal(node.right, li);

    }
}