class Solution {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        TreeNode leftTail = dfs(left);
        TreeNode rightTail = dfs(right);

        if (left != null) {
            node.right = left;
            node.left = null;

            leftTail.right = right;
        }

        if (rightTail != null) {
            return rightTail;
        }

        if (leftTail != null) {
            return leftTail;
        }

        return node;
    }
}