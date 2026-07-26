/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
    
//     Map<TreeNode, Integer> map = new HashMap<>();
        
//     public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//         List<Integer> res = new LinkedList<>();
//         find(root, target);
//         dfs(root, target, K, map.get(root), res);
//         return res;
//     }
    
//     // find target node first and store the distance in that path that we could use it later directly
//     private int find(TreeNode root, TreeNode target) {
//         if (root == null) return -1;
//         if (root == target) {
//             map.put(root, 0);
//             return 0;
//         }
//         int left = find(root.left, target);
//         if (left >= 0) {
//             map.put(root, left + 1);
//             return left + 1;
//         }
// 		int right = find(root.right, target);
// 		if (right >= 0) {
//             map.put(root, right + 1);
//             return right + 1;
//         }
//         return -1;
//     }
    
//     private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
//         if (root == null) return;
//         if (map.containsKey(root)) length = map.get(root);
//         if (length == K) res.add(root.val);
//         dfs(root.left, target, K, length + 1, res);
//         dfs(root.right, target, K, length + 1, res);
//     }
// }




class Solution {
    List<Integer> res = new ArrayList<>();

public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    dfs(root, target, k);
    return res;
}

// returns distance node→target if target is in this subtree, else -1
private int dfs(TreeNode node, TreeNode target, int k) {
    if (node == null) return -1;

    if (node == target) { collect(node, k); return 0; }

    int l = dfs(node.left, target, k);
    if (l >= 0) {
        if (l + 1 == k) res.add(node.val);
        else collect(node.right, k - l - 2);
        return l + 1;
    }

    int r = dfs(node.right, target, k);
    if (r >= 0) {
        if (r + 1 == k) res.add(node.val);
        else collect(node.left, k - r - 2);
        return r + 1;
    }
    return -1;
}

// all nodes exactly d below node
private void collect(TreeNode node, int d) {
    if (node == null || d < 0) return;
    if (d == 0) { res.add(node.val); return; }
    collect(node.left, d - 1);
    collect(node.right, d - 1);
}
}