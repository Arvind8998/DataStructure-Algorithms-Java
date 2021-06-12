package BinaryTrees;

import java.util.ArrayList;

public class InOrderPrePostOrderTraversal {

    public static class Node{
        private int data;
        private Node left;
        private Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data){
            this(data, null, null);
        }
    }

    public static void PreOrder(Node root, ArrayList<Integer> ans){
        if (root == null){
            return;
        }

        ans.add(root.data);
        PreOrder(root.left, ans);
        PreOrder(root.right, ans);

    }

    public static void InOrder(Node root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }

        InOrder(root.left,ans);
        ans.add(root.data);
        InOrder(root.right, ans);
    }

    public static void PostOrder(Node root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }

        PostOrder(root.left,ans);
        PostOrder(root.right, ans);
        ans.add(root.data);

    }

    public static int size(Node node){
        if(node == null){
            return 1;
        }
        int left 
    }

    public static int sum(Node node){
        if(node == null){
            return 0;
        }
        int left = sum(node.left);
        int right = sum(node.right);
        return left + right + node.data;
    }

    public static int max(Node node){
        if(node == null){
            return -(int)1e9;
        }
        int left = max(node.left);
        int right = max(node.right);
        return Math.max(Math.max(left ,right), node.data);
    }

    public static int min(Node node){
        if(node == null){
            return (int)1e9;
        }
        int left = min(node.left);
        int right = min(node.right);
        return Math.min(Math.min(left ,right), node.data);
    }

    // if edge height is to be returned return -1, for node height return 0
    public static int height(Node node){
        if(node == null){
            return -1;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left + right) + 1;
    }
}
