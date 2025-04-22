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
    //         1
    //     2       3
    // 4     5   6.   7


    // Inorder = 4 2 5 1 6 3 7
    // PostOrder  = 4 5 2 6 7 3 1 


    // 4 2 5 left 

    // 6 3 7 right



class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       Map<Integer, Integer> mp = new HashMap<>(); 
        
        int len = postorder.length;
       for(int i = 0; i < len; ++i){
        mp.put(inorder[i], i);
       }

       return build(inorder, 0, len-1, postorder, 0, len-1, mp);
    }


    private TreeNode build(int[] inorder,int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> mp ){

        if(inStart > inEnd|| postStart > postEnd) return null;

        TreeNode node = new TreeNode(postorder[postEnd]);

        int inIndex = mp.get(postorder[postEnd]);

        int nLeft = inIndex - inStart;
        int nRight = inEnd - inIndex;

        node.left = build(inorder, inStart, inIndex - 1, postorder, postStart, postStart + nLeft - 1,mp);
        node.right  = build(inorder, inIndex + 1, inEnd, postorder, postEnd - nRight,postEnd -1,mp);


        return node;

    }
}