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
    
    public void nAryTreePreorder(Node node, List<Integer> ans){
         ans.add(node.val);
        
        for(Node child: node.children){
            nAryTreePreorder(child, ans);
        }
    }
    
    public List<Integer> preorder(Node root) {
        
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null){
            return ans;
        }
        nAryTreePreorder(root, ans);
        return ans;
        
    }
}


