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
class BSTIterator {
    private Deque<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        stk = new ArrayDeque<>();
        pushLeftBranch(root);
    }
    
    private void pushLeftBranch(TreeNode node) {
        while (node != null) {
            stk.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode curr = stk.pop();
        if (curr.right != null) {
            pushLeftBranch(curr.right);
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */