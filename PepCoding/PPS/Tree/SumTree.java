package Tree;

class Tree {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    Node root;
    int sum = 0;
    public void sumTree(Node itr) {
        if (itr != null) {
            sumTree(itr.left);
            sum = sum + itr.value;
            sumTree(itr.right);
        }
    }
}

public class SumTree {
    public static void main(String args[]) {
        Tree tree=new Tree();
        // nnllnll, nlnll, nlnnlll
        tree.root=new Tree.Node(26);
        tree.root.left=new Tree.Node(10);
        tree.root.right=new Tree.Node(3);
        tree.root.left.left=new Tree.Node(4);
        tree.root.left.right=new Tree.Node(6);
        tree.root.right.right=new Tree.Node(3);

        tree.sumTree(tree.root);
        if (tree.sum/2 == tree.root.value) {
            System.out.println("SUM TREE");
        } else {
            System.out.println("NOT SUM TREE");
        }
    }
}
