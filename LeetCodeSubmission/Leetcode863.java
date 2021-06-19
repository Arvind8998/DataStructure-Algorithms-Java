/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public boolean nodeToRootPath(TreeNode node, int data, ArrayList<TreeNode> ans) {
       if (node == null)
           return false;

       if (node.val == data) {
           ans.add(node);
           return true;
       }
       boolean res = nodeToRootPath(node.left, data, ans) || nodeToRootPath(node.right, data, ans);
       if (res)
           ans.add(node);

       return res;
   }

   public static void KLevelsDown(TreeNode node, TreeNode block, int k, List<Integer> ans) {
       if (node == null || k < 0 || node == block)
           return;

       if (k == 0) {
           ans.add(node.val);
           return;
       }

       KLevelsDown(node.left, block, k - 1, ans);
       KLevelsDown(node.right, block, k - 1, ans);
   }

   public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       ArrayList<TreeNode> list = new ArrayList<>();

       nodeToRootPath(root, target.val, list);
       for(TreeNode a : list)
           System.out.println(a.val);

       List<Integer> ans = new ArrayList<Integer>();
       TreeNode block = null;
       for (int i = 0; i < list.size(); i++) {
           KLevelsDown(list.get(i), block, k - i, ans);
           block = list.get(i);
       }
       
       return ans;
   }
}