package GenericTrees;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GenericTree {

    public static class Node {
        int data = 0;
        ArrayList<Node> childs;

        Node(int data) {
            this.data = data;
            this.childs = new ArrayList<>();
        }
    }

    public static int height(Node root) {
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
        if (node == data) {
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
        return ans;
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        if (node == data) {
            ArrayList<Node> base = new ArrayList<>();
            base.add(node);
            return base;
        }

        ArrayList<Node> smallAns = new ArrayList<>();

        for (Node child : node.children) {
            smallAns = nodeToRootPath(node, data);
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

    public static boolean IsSymmetric(Node node){
        return areSymmetricMirror(node, node);
    }

    static int floor;
    static int ceil;

    public static void _ceilAndFloor(Node node, int data) {
        if(node.data < data){
            floor = Math.max(node.data, data);
        }
        if(node.data > data){
            floor = Math.min(node.data, data);
        }
        for(Node child: node.children){
            ceilAndFloor(child, data);
      }
    }

    public static void ceilAndFloor(Node node, int data) {
        floor = -(int)1e9;
        ceil = (int)1e9;
        _ceilAndFloor(node, data);
    }

    public int floor(Node node, int ub){
        int maxRes = -(int)1e9;


        for(Node child: node.children){
          maxRes = Math.max(maxRes, floor(child, ub));

        }

        return node.data < ub ? Math.max()
    }
}
