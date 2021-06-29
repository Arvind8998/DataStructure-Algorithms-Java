package GenericTrees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class GenericTree {

    public static class Node {
        int data = 0;
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public static int height(Node node) {
        int sum = -1;

        for (Node child : node.children) {
            sum += height(child);
        }
        return sum + 1;
    }

    public static int size(Node node) {
        int sum = 0;

        for (Node child : node.children) {
            sum += size(child);
        }
        return sum + 1;
    }

    public static int maximum(Node node) {

        int maximum = node.data;

        for (Node child : node.children) {
            Math.max(maximum(child), maximum);
        }
        return maximum;
    }

    public static int minimum(Node node) {
        int min = node.data;

        for (Node child : node.children) {
            Math.max(minimum(child), min);
        }
        return min;
    }

    public static int sum(Node node) {
        int sum = node.data;

        for (Node child : node.children) {
            sum += sum(child);
        }
        return sum;
    }

    public static boolean find(Node node, int data) {
        if (node.data == data)
            return true;

        boolean res = false;
        for (Node child : node.children) {
            res = res || find(child, data);
        }
        return res;
    }

    public static boolean nodeToRootPath(Node node, int data, ArrayList<Node> ans) {
        if (node.data == data) {
            ans.add(node);
            return true;
        }

        boolean res = false;
        for (Node child : node.children) {
            res = res || nodeToRootPath(node, data, ans);
        }

        if (res) {
            ans.add(node);
        }
        return res;
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Node> base = new ArrayList<>();
            base.add(node);
            return base;
        }

        ArrayList<Node> smallAns = new ArrayList<>();

        for (Node child : node.children) {
            smallAns = nodeToRootPath(child, data);
            if (smallAns.size() != 0) {
                break;
            }
        }

        if (smallAns.size() != 0) {
            smallAns.add(node);
        }
        return smallAns;
    }

    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        int lcaNode = lca(node, d1, d2);
        ArrayList<Integer> lcaNodeToRootNodePath = nodeToRootPath(node, lcaNode);
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);
        return p1.size() + p2.size() - 2 * (lcaNodeToRootNodePath.size());
    }

    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }
        boolean res = true;

        for (int i = 0; i < n1.children.size(); i++) {
            Node child1 = n1.children.get(i);
            Node child2 = n2.children.get(i);
            res = res && areSimilar(child1, child2);
        }
        return res;
    }

    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size() && n1.data != n2.data) {
            return false;
        }

        boolean res = true;
        for (int i = 0; i < n1.children.size(); i++) {
            Node child1 = n1.children.get(i);
            Node child2 = n2.children.get(n2.children.size() - i - 1);
            res = res && areMirror(child1, child2);
        }
        return res;
    }

    public static boolean areSymmetricMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        boolean res = true;
        for (int i = 0; i < n1.children.size(); i++) {
            Node child1 = n1.children.get(i);
            Node child2 = n2.children.get(n2.children.size() - i - 1);
            res = res && areMirror(child1, child2);
        }
        return res;
    }

    public static boolean IsSymmetric(Node node) {
        return areSymmetricMirror(node, node);
    }

    static int floor;
    static int ceil;

    public static void _ceilAndFloor(Node node, int data) {
        if (node.data < data) {
            floor = Math.max(node.data, data);
        }
        if (node.data > data) {
            floor = Math.min(node.data, data);
        }
        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }

    public static void ceilAndFloor(Node node, int data) {
        floor = -(int) 1e9;
        ceil = (int) 1e9;
        _ceilAndFloor(node, data);
    }

    public static int floor(Node node, int ub) {
        int maxRes = -(int) 1e9;
        for (Node child : node.children) {
            int recAns = floor(child, ub);
            maxRes = Math.max(maxRes, recAns);
        }
        return node.data < ub ? Math.max(node.data, maxRes) : maxRes;
    }

    public static int kthLargest(Node node, int k) {
        int ub = (int) 1e9;
        for (int i = 0; i < k; i++) {
            ub = floor(node, ub);
        }
        return ub;
    }

    public static void levelOrder(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                Node lastNode = queue.removeFirst();
                System.out.print(lastNode.data + " ");
                for (Node child : lastNode.children) {
                    queue.addLast(child);
                }
            }
            level++;
        }
        System.out.print(".");
    }

    public static void levelOrderLinewise(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        int level = 0;

        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                Node rn = queue.removeFirst();
                System.out.print(rn.data + " ");

                if (rn.left != null) {
                    queue.addLast(rn.left);
                }
                if (rn.right != null) {
                    queue.addLast(rn.right);
                }
            }
            level++;
        }
        System.out.println();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        queue.addLast(root);
        int level = 0;
        
        while(queue.size() > 0) {
            int size = queue.size();
            List<Integer> base = new ArrayList<>();
            whike(size-- > 0){
                TreeNode rn = queue.removeFirst();
                base.add(rn.data);

            if(level % 2 == 0){
                for(Node child : root.children){
                    stack.addFirst(child.data);
                }
            }
            else{
                for(int i = rn.children.size()-1; i>=0; i--){
                    Node child = rn.children.get(i);
                    stack.addFirst(child);
                }
            }
            
        }
        
    }
    level++;
    ans.add(base);
    LinkedList<Node> temp = queue;
    
}
