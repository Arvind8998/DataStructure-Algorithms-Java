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
    public void PostOrder(TreeNode root, ArrayList<Integer> ans){
      if(root == null){
          return;
      }

      PostOrder(root.left,ans);
      PostOrder(root.right, ans);
      ans.add(root.val);
  }
  
  public List<Integer> postorderTraversal(TreeNode root) {
      ArrayList<Integer> ans = new ArrayList<Integer>();
      PostOrder(root, ans);
      return ans;
  }
}