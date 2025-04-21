// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
// class Solution {
//      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//         List<TreeNode> li1  =  new ArrayList<>();
//         List<TreeNode> li2  =  new ArrayList<>();
//         TreeNode t1 = new TreeNode(Integer.MIN_VALUE);
//         li1.add(root);
//         li2.add(root);

//         generateList(root, p, li1);
//         generateList(root, q, li2);
//         int li_size  = li1.size();
//         for(int i = li_size-1 ;  i>=0; --i){
//             t1 = li1.get(i);

//             if(li2.contains(t1)) break;
//         }

//         return t1;


//     }

//     private boolean generateList(TreeNode root, TreeNode p, List<TreeNode> li) {
//         if (root == null)
//             return false;

//         if (root.val == p.val){
//             // li.add(root);
//             return true;
//         }
            

//         if (root.left != null) {
//             li.add(root.left);
//             if (generateList(root.left, p, li)) {
//                 return true;   
//             }
//             li.remove(li.size() - 1);
//         }
//         if (root.right != null) {
//             li.add(root.right);
//             if (generateList(root.right, p, li)) {
//                 return true;   
//             }
//             li.remove(li.size() - 1);
//         }
//         return false;
//     }
// }


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root != null && root.val== 4)System.out.println("here how");

        if(root == null) return null;
        if ( root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) return null;
        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;        
    }
}