package Tree;

class TreeBuild {
    class Node {
        int value;
        Node left, right;

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

    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public Node invert(Node root) {
        if (root == null) return null;

        Node newNode = new Node(root.value);
        newNode.left = invert(root.right);
        newNode.right = invert(root.left);

        return newNode;
    }
}
public class InvertTree {
    public static void main(String[] args) {
        TreeBuild bst = new TreeBuild();
        bst.addNode(4);
        bst.addNode(2);
        bst.addNode(7);
        bst.addNode(1);
        bst.addNode(3);
        bst.addNode(6);
        bst.addNode(9);
        TreeBuild.Node node = bst.invert(bst.root);
        bst.preOrder(node);
    }
}
