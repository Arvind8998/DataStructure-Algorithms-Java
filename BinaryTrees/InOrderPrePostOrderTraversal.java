package BinaryTrees;

import java.util.ArrayList;

public class InOrderPrePostOrderTraversal {

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data) {
            this(data, null, null);
        }
    }

    public static void PreOrder(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.data);
        PreOrder(root.left, ans);
        PreOrder(root.right, ans);

    }

    public static void InOrder(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        InOrder(root.left, ans);
        ans.add(root.data);
        InOrder(root.right, ans);
    }

    public static void PostOrder(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        PostOrder(root.left, ans);
        PostOrder(root.right, ans);
        ans.add(root.data);

    }

    public static int size(Node node) {
        if(node == null) return 0;
        int left = size(node.left);
        int right = size(node.right);
        return left+right+1;
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
        if (node == null) {
            return -(int) 1e9;
        }
        int left = max(node.left);
        int right = max(node.right);
        return Math.max(Math.max(left, right), node.data);
    }

    public static int min(Node node) {
        if (node == null) {
            return (int) 1e9;
        }
        int left = min(node.left);
        int right = min(node.right);
        return Math.min(Math.min(left, right), node.data);
    }

    // if edge height is to be returned return -1, for node height return 0
    public static int height(Node node) {
        if(node == null) return -1;
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) +1;
      }

    public static boolean findData(Node node, int data){
        if(node == null) return false;

        if(node.data == data) return true;

        return findData(node.left, data) || findData(node.right, data)
    }

    public static boolean nodeToRootPath(Node node, int data, ArrayList<Node> ans) {
        if (node == null)
            return false;

        if (node.data == data) {
            ans.add(node);
            return true;
        }

        boolean res = nodeToRootPath(node.left, data, ans) || nodeToRootPath(node.right, data, ans);

        if (res) {
            ans.add(node);
        }
        return res;
    }

    public static ArrayList<Node> nodeToRootPath(Node root, int data) {
        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath(root, data, ans);
        return ans;
    }

    public static ArrayList<Integer> __nodeToRootPath(Node node, int data){
        if(node == null) return new ArrayList<Integer>();
        
        if(node.data == data){
            ArrayList<Integer> base = new ArrayList<Integer>();
            base.add(node.data);
            return base;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        ArrayList<Integer> left = __nodeToRootPath(node.left, data);
        ArrayList<Integer> right = __nodeToRootPath(node.right, data);
        
        if(left.size() >0){
            for(int el: left)
                ans.add(el);
            ans.add(node.data);
            return ans;
        }
        
        else if(right.size() >0){
            for(int el: right)
                ans.add(el);
            ans.add(node.data);
            return ans;
        }
        
        
        return ans;
      }

    public static void KLevelsDown(Node node, int k,ArrayList<Integer> ans) {
        if (node == null || k < 0 )
            return;

        if (k == 0) {
            ans.add(node.data);
            return;
        }

        KLevelsDown(node.left, k - 1, ans);
        KLevelsDown(node.right, k - 1, ans);
    }

    public static void printKLevelsDown2(Node node, int k) {
        if (node == null || k == -1)
            return;

        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
        if (k == 0)
            System.out.println(node.data);
    }

    public int heightofNode(Node node) {
        if (node == null)
            return -1;

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(Node node) {
        if (node == null)
            return true;

        if (Math.abs(heightofNode(node.left) - heightofNode(node.right)) <= 1
                && Math.abs(heightofNode(node.left) - heightofNode(node.right)) > 0)
            return true;

        boolean isleftBalanced = isBalanced(node.left);
        boolean isrightBalanced = isBalanced(node.right);

        if (isleftBalanced && isrightBalanced) {
            return true;
        }
        return false;
    }

    public class bPair {
        int height = -1;
        boolean isBal = true;
    }

    public static bPair isBalanced2(Node node) {
        if (node == null)
            return new bPair();

        bPair lPair = isBalanced2(node.left);
        if (lPair.isBal) {
            return lPair;
        }

        bPair rPair = isBalanced2(node.right);
        if (rPair.isBal) {
            return rPair;
        }

        bPair ans = new bPair();

        if (Math.abs(lPair.height - rPair.height) > 1) {
            ans.isBal = false;
            return ans;
        }

        ans.height = Math.max(lPair.height, rPair.height) + 1;
        return ans;

    }

    public int isBalanced3(Node node) {
        if (node == null)
            return -1;

        int lH = isBalanced3(node.left);
        if (lH == -2)
            return lH;

        int rH = isBalanced3(node.right);
        if (rH == -2)
            return rH;

        if (Math.abs(lH - rH) > 1) {
            return -2;
        }

        return Math.max(lH, rH) + 1;
    }

    public class tiltPair {
        int tsf = 0;
        int sum = 0;
    }

    public tiltPair treeTilt(Node node) {
        if (node == null) {
            return new tiltPair();
        }

        tiltPair leftTilt = treeTilt(node.left);
        tiltPair rightTilt = treeTilt(node.right);

        tiltPair ans = new tiltPair();
        ans.tsf = leftTilt.tsf + rightTilt.tsf + Math.abs(leftTilt.sum - rightTilt.sum);
        ans.sum = leftTilt.sum + rightTilt.sum + node.val;

        return ans;
    }

    public static class largestBTPair{
        boolean isBST = true;
        int max = -(int)1e9;
        int min = (int)1e9;
        
        int maxSize = 0;
        Node node = null;
    }
    
    public static largestBTPair largestBTree(Node node){
        if(node == null) return new largestBTPair();
        
        largestBTPair lPair = largestBTree(node.left);
        largestBTPair rPair = largestBTree(node.right);
        
        largestBTPair myAns = new largestBTPair();
        
        if(lPair.isBST && rPair.isBST && lPair.max < node.data && rPair.min > node.data){
            myAns.isBST = true;
            myAns.max = Math.max(node.data, rPair.max);
            myAns.min = Math.min(node.data, lPair.min);
            myAns.maxSize = lPair.maxSize + rPair.maxSize +1;
            myAns.node = node;
        }
        
        else{
            myAns.isBST = false;
            myAns.maxSize = lPair.maxSize > rPair.maxSize ? lPair.maxSize : rPair.maxSize;
            myAns.node = lPair.maxSize > rPair.maxSize ? lPair.node : rPair.node;
        }   
      return myAns;
    }

}
