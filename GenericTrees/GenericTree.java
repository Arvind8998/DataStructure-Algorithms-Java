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

    public static ArrayList<Integer> __nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> base = new ArrayList<Integer>();
            base.add(node.data);
            return base;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (Node child : node.children) {
            ArrayList<Integer> recAns = __nodeToRootPath(child, data);
            if (recAns.size() > 0) {
                for (int a : recAns) {
                    ans.add(a);
                }
                break;
            }

        }
        if (ans.size() > 0) {
            ans.add(node.data);
        }

        return ans;
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

    public static Node getTail(Node node) {
        while (node.children.size() != 0) {
            node = node.children.get(0);
        }
        return node;
    }

    public static void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }
        for (int i = node.children.size() - 1; i > 0; i--) {
            Node tail = getTail(node.children.get(i - 1));
            tail.children.add(node.children.get(i));
            node.children.remove(i);
        }
    }

    public static ArrayList<Integer> ___nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for (Node child : node.children) {
            ArrayList<Integer> ptc = ___nodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> path1 = ___nodeToRootPath(node, d1);
        ArrayList<Integer> path2 = ___nodeToRootPath(node, d2);
        int l1 = path1.size() - 1, l2 = path2.size() - 1, potentialLca = -1;
        while (l1 >= 0 && l2 >= 0) {
            if (path1.get(l1) != path2.get(l2))
                break;
            potentialLca = path1.get(l1);
            l1--;
            l2--;

        }
        return potentialLca;
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

    public static void levelOrderLinewiseZZ(Node node){
        LinkedList<Node> stack = new LinkedList<Node>();
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(node);
        
        int level = 0;
        while(queue.size() >0){
            int size = queue.size();
            while(size -- >0){
               Node removedLast = queue.removeFirst();
               System.out.print(removedLast.data + " ");
               if(level % 2 == 0){
                   for(Node child : removedLast.children)
                   stack.addFirst(child);
               }
               else{
                   for(int i= removedLast.children.size()-1; i >=0; i--){
                       stack.addFirst(removedLast.children.get(i));
                   }
               }
            }
            level++;
            LinkedList<Node> temp = queue;
            queue = stack;
            stack = temp;
            System.out.println();
        }
      }
