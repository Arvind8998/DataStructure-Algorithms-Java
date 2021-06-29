/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        while(queue.size() >0){
            int size = queue.size();
            ArrayList<Integer> base = new ArrayList<>();
            
            while(size-- > 0){
                TreeNode rn = queue.removeLast();
                base.add(rn.val);
                
                for(Node child: node.children){
                    queue.addLast(child);
                }
            }
            ans.add(base);
            level++;
        }
        return ans;
    }
}