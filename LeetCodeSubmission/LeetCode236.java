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
    
    public boolean nodeToRootPath(TreeNode node, int data, ArrayList<TreeNode> ans){
        if(node == null) return false;
        
        if(node.val == data){
            ans.add(node);
            return true;
        }
        
        boolean res = nodeToRootPath(node.left, data, ans) || nodeToRootPath(node.right, data, ans);
        if(res) ans.add(node);
        return res;
        
    }
    
    public ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data){
        ArrayList<TreeNode> ans = new ArrayList<>();
        nodeToRootPath(node, data, ans);
        return ans;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        ArrayList<TreeNode> path1 = nodeToRootPath(root, p.val);
        ArrayList<TreeNode> path2 = nodeToRootPath(root, q.val);
        
        int rp1 = path1.size() -1;
        int rp2 = path2.size() -1;
        
        for(TreeNode curr: path2)
            System.out.print(curr.val);
        
        TreeNode potentialLca = null;
        
            while(rp1 >= 0 && rp2 >= 0){
            if(path1.get(rp1) != path2.get(rp2))
                break;
            potentialLca = path2.get(rp2);
            rp1--;
            rp2--;
        }
        
        return potentialLca;
    }
}