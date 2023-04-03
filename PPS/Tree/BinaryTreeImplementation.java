package Tree;

class BST {
    class Node {
        private int value;
        private Node left, right;

        Node () {this(0);}

        Node (int value) {
            this.value = value;
            left = right = null;
        }
    }

    Node root;

    public void addNode(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }

        Node itr = root;
        Node parent;

        while (true) {
            if (val < itr.value) {
                parent = itr;
                itr = itr.left;
                if (itr == null) {
                    parent.left = new Node(val);
                    return;
                }
            } else {
                parent = itr;
                itr = itr.right;
                if (itr == null) {
                    parent.right = new Node(val);
                    return;
                }
            }
        }
    }

    public void preOrder(Node itr) {
        if (itr != null) {
            System.out.print(itr.value + " ");
            preOrder(itr.left);
            preOrder(itr.right);
        }
    }

    public void postOrder(Node itr) {
        if (itr != null) {
            preOrder(itr.left);
            preOrder(itr.right);
            System.out.print(itr.value + " ");
        }
    }

    public void inOrder(Node itr) {
        if (itr != null) {
            preOrder(itr.left);
            System.out.print(itr.value + " ");
            preOrder(itr.right);
        }
    }
}

public class BinaryTreeImplementation {
    public static void main (String args[]) {
        BST bst = new BST();
        bst.addNode(4);
        bst.addNode(2);
        bst.addNode(7);
        bst.addNode(1);
        bst.addNode(3);
        bst.addNode(6);

        bst.inOrder(bst.root);
        System.out.println();
        bst.preOrder(bst.root);
        System.out.println();
        bst.postOrder(bst.root);
    }
}
