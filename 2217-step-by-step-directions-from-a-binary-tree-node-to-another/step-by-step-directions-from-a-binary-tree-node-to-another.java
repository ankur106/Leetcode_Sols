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
   public String getDirections(TreeNode root, int startValue, int destValue) {
    StringBuilder s = new StringBuilder(), d = new StringBuilder();
    find(root, startValue, s);
    find(root, destValue, d);

    int i = 0;                                    // strip common prefix
    while (i < s.length() && i < d.length() && s.charAt(i) == d.charAt(i)) i++;

    return "U".repeat(s.length() - i) + d.substring(i);
}

private boolean find(TreeNode node, int val, StringBuilder sb) {
    if (node == null) return false;
    if (node.val == val) return true;

    sb.append('L');
    if (find(node.left, val, sb)) return true;
    sb.deleteCharAt(sb.length() - 1);

    sb.append('R');
    if (find(node.right, val, sb)) return true;
    sb.deleteCharAt(sb.length() - 1);

    return false;
}
}