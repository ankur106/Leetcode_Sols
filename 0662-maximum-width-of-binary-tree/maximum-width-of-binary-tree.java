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

    class Node {
        TreeNode node;
        long index; // Using long to prevent integer overflow

        Node(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(root, 0));
        int maxWidth = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            long leftIndex = queue.peekFirst().index;
            long rightIndex = queue.peekLast().index;
            
            // Update max width
            maxWidth = Math.max(maxWidth, (int)(rightIndex - leftIndex + 1));
            
            // Process current level
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                long currentIndex = current.index;
                
                // Add children to queue with adjusted indices
                if (current.node.left != null) {
                    queue.offer(new Node(current.node.left, 2 * currentIndex + 1));
                }
                
                if (current.node.right != null) {
                    queue.offer(new Node(current.node.right, 2 * currentIndex + 2));
                }
            }
        }
        
        return maxWidth;
    }
}
