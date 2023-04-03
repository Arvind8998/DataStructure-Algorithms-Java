package Tree;

import java.util.Arrays;

class Euler {
    static class Node {
        int data;
        Node left, right;

        Node (int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;
    int size = 0;
    int[] eulerTour;
    int counter = 0;
    Euler(int size) {
        this.size = 2 * size - 1;
        eulerTour = new int[this.size];
    }

    public void EulerTour(Node root) {
        if (root == null) return;

        eulerTour[counter] = root.data;
        if (root.left != null) {
            counter += 1;
            EulerTour(root.left);
            counter += 1;
            eulerTour[counter] = root.data;
        }

        if (root.right != null) {
            counter += 1;
            EulerTour(root.right);
            counter += 1;
            eulerTour[counter] = root.data;
        }
    }
}

public class EulerTour {
    public static void main(String[] args) {
        Euler tree = new Euler(8);
        tree.root = new Euler.Node(1);
        tree.root.left = new Euler.Node(2);
        tree.root.right = new Euler.Node(3);
        tree.root.left.left = new Euler.Node(4);
        tree.root.left.right = new Euler.Node(5);
        tree.root.right.left = new Euler.Node(6);
        tree.root.right.right = new Euler.Node(7);
        tree.root.right.left.right = new Euler.Node(8);

        tree.EulerTour(tree.root);
        System.out.println(Arrays.toString(tree.eulerTour));
    }
}
