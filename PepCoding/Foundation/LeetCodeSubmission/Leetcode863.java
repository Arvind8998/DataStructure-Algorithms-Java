/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data){
        if(node == null) return null;
        
        if(node.val == data){
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(node);
            return base;
        }
        ArrayList<TreeNode> left = nodeToRootPath(node.left, data);
        if(left !=null){
            left.add(node);
            return left;
        }
        
        ArrayList<TreeNode> right = nodeToRootPath(node.right, data);
        if(right !=null){
            right.add(node);
            return right;
        }
        
        return null;
        
    }
    
    public void kLeveldown(TreeNode node, TreeNode block, int k, ArrayList<Integer> ans){
        if(node == null || k<0 || node == block) return;
        
        if(k==0){
            ans.add(node.val);
            return;
        }
        
        kLeveldown(node.left, block, k-1, ans);
        kLeveldown(node.right, block, k-1, ans);
    }
    
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> list = nodeToRootPath(root, target.val);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        TreeNode block = null;
        for(int i=0; i<list.size(); i++){
            kLeveldown(list.get(i), block, k-i, ans);
            block = list.get(i);
        }
        return ans;
    }
}