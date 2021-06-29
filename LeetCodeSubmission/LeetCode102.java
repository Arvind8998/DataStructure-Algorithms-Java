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
    
    public void levelOrderLinewise(TreeNode node, List<List<Integer>> ans){
        
       LinkedList<TreeNode> queue = new LinkedList<>();
       queue.addLast(node);
       int level = 0;

       while(queue.size() > 0){
           int size = queue.size();
           List<Integer> base = new ArrayList<>();
           while(size-- > 0){
               TreeNode rn = queue.removeFirst();
               base.add(rn.val);
               

               if(rn.left != null){
                   queue.addLast(rn.left);
               }
               if(rn.right != null){
                   queue.addLast(rn.right);
               }
           }
           ans.add(base);
           level++;
       }
     }
   
   public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> ans = new ArrayList<>();
       if(root == null) return ans;
       levelOrderLinewise(root, ans);
       return ans;
   }
}