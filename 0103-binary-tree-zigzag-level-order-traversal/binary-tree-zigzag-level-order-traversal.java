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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>  ans  = new ArrayList<>();
        if(root == null) return ans;

        Deque<TreeNode> que = new ArrayDeque<>();

        que.offer(root);

        int level = 0;
        while(!que.isEmpty()){

            int size = que.size();

            List<Integer> levTvs = new ArrayList<>();
            Deque<TreeNode> nextLevel = new ArrayDeque<>();

            while(size > 0){

                if(level % 2 ==0){
                    TreeNode curr = que.pollFirst();
                    levTvs.add(curr.val);
                    if(curr.left != null)nextLevel.add(curr.left);
                    if(curr.right != null)nextLevel.add(curr.right);
                }else{
                    TreeNode curr = que.pollLast();
                    levTvs.add(curr.val);
                    if(curr.right != null)nextLevel.offerFirst(curr.right);
                    if(curr.left != null)nextLevel.offerFirst(curr.left);
                }

                size--;

            }

            ans.add(levTvs);
            que = nextLevel;
            level++;

        }

        return ans;
        
    }
}