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
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<String>();
        
            if(root.left == null && root.right == null){
                 List<String> base = new ArrayList<String>();
                     
                     
                 base.add(root.val+"");
                     
                return base;
                }
        List<String> ans = new ArrayList<String>();
        
        List<String> left = binaryTreePaths(root.left);
        if(left.size()>0){
            for(String a : left){
            ans.add(root.val+"->"+a);
        }
        }
        
        List<String> right = binaryTreePaths(root.right);
        if(right.size()>0){
            for(String b : right){
            ans.add(root.val+"->"+b);
        }
        }
         
        
        return ans;
        
    }
}