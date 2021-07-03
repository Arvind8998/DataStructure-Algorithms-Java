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
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        queue.addLast(root);
        int level = 0;
        
        while(queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> levelData = new ArrayList<>();
            
            while(size-- > 0){
                TreeNode rn = queue.removeFirst();
                levelData.add(rn.val);
            
            if(level % 2 == 0){
                if(rn.left != null)
                    stack.addFirst(rn.left);
                
                if(rn.right != null)
                    stack.addFirst(rn.right);
            }
            else{
            if(rn.right != null)
                stack.addFirst(rn.right);
             if(rn.left != null)
                stack.addFirst(rn.left);
            }
        }
            level++;
            ans.add(levelData);
            LinkedList<TreeNode> temp = queue;
            queue = stack;
            stack = temp;
        
    }
        return ans;
}
}