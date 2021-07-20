package BinarySearchTree;

import java.util.*;

public class BST {
    public static class Node {
        Node left = null;
        Node right = null;
        int data = 0;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int size(Node node) {
        return node == null ? 0 : size(node.left) + size(node.right) + 1;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int left = sum(node.left);
        int right = sum(node.right);
        return left + right + node.data;
    }

    public static int max(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    public static int min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public static boolean find(Node node, int data) {
        while (node != null) {
            if (node.data == data)
                return true;
            else if (node.data < data)
                node = node.right;
            else
                node = node.left;
        }

        return false;
    }

    public static int lca(Node node, int d1, int d2) {
        int lca = -1;
        while (node != null) {
            if (node.data < d1 && node.data < d2)
                node = node.right;
            else if (d1 < node.data && d2 < node.data)
                node = node.left;
            else {
                lca = node.data;
                break;
            }

        }
        return lca;
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        ArrayList<Node> list = new ArrayList<>();
        boolean flag = false;

        while (node != null) {
            list.add(node);
            if (node.data == data) {
                flag = true;
                break;
            } else if (node.data < data) {
                node = node.right;
            } else
                node = node.left;
        }

        if (!flag) {
            list.clear();
        }
        Collections.reverse(list);
        return list;
    }

    public static void pir(Node node, int d1, int d2) {
        if (node == null)
            return;
        pir(node.left, d1, d2);
        if (node.data >= d1 && node.data <= d2)
            System.out.println(node.data);
        pir(node.right, d1, d2);
    }

    public static Node add(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (node.data < data) {
            node.right = add(node.right, data);
        } else if (node.data > data) {
            node.left = add(node.left, data);
        }
        return node;
    }

    public static Node removeNode(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (node.data < data) {
            node.right = removeNode(node.right, data);
        } else if (node.data > data) {
            node.left = removeNode(node.left, data);
        } else {
            if (node.left == null || node.right == null)
                return node.left != null ? node.left : node.right;

            else {
                int minEle = min(node.right);
                node.data = minEle;
                node.right = removeNode(node.right, minEle);
            }
        }
        return node;
    }

    /*
     * Add all greater values to every node in a BST
     * 
     * https://practice.geeksforgeeks.org/problems/add-all-greater-values-to-every-
     * node-in-a-bst/1#
     */

    public void modify(Node node, int[] arr) {
        if (node == null)
            return;
        modify(node.right, arr);
        node.data += arr[0];
        arr[0] = node.data;
        modify(node.left, arr);
    }

    // modify the BST and return its root
    public Node modify(Node root) {
        // Write your code here
        int[] arr = new int[1];
        modify(root, arr);
        return root;
    }

    // Replace with sum of larger
    static int sum = 0;

    public static void rwsol(Node node) {
        if (node == null)
            return;

        rwsol(node.right);

        int original = node.data;
        node.data = sum;
        sum += original;

        rwsol(node.left);
    }
}
