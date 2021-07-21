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
    
    public class diameterPair {
        int height = -1;
        int diameter = 0;
    }
    
    
    public diameterPair diameterofBST(TreeNode node){
        if(node == null) return new diameterPair();
        
        diameterPair ld = diameterofBST(node.left);
        diameterPair rd = diameterofBST(node.right);
        
        diameterPair myAns = new diameterPair();
        
        myAns.height = Math.max(ld.height, rd.height) +1;
        myAns.diameter = Math.max( Math.max(ld.diameter, rd.diameter),          ld.height+ rd.height+2);
        return myAns;
        
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameterPair ans = diameterofBST(root);
        return ans.diameter;
        
    }
}