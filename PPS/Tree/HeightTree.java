package Tree;

class Binary {
    Node root;
    int size = 0;
    int level = 0;
    class Node {
        private int value;
        private Node left, right;
        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public void addNode(int val) {
        if (root == null) {
            root = new Node(val);
            size += 1;
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
                    size += 1;
                    return;
                }
            } else {
                parent = itr;
                itr = itr.right;
                if (itr == null) {
                    parent.right = new Node(val);
                    size += 1;
                    return;
                }
            }
        }
    }

    public int height(Node itr) {
        if (itr == null) return 0;

        int left = height(itr.left);
        int right = height(itr.right);

        return Math.max(right, left) + 1;
    }

    public int depth(String preOrder, int index, int n) {
        if (index  >= n || preOrder.charAt(index) == 'l') return 0;

        index += 1;
        int left = depth(preOrder, index, n);

        index += 1;
        int right = depth(preOrder, index, n);

        return Math.max(right, left) + 1;
    }
}

public class HeightTree {
    public static void main (String args[]) throws Exception {
        Binary bst = new Binary();
        //        4
        //      1    5
        //    0    2
        //           3
        bst.addNode(4);
        bst.addNode(1);
        bst.addNode(2);
        bst.addNode(3);
        bst.addNode(5);
        bst.addNode(0);
        int h = bst.height(bst.root) -1;
        System.out.println("Depth: " + h);
        System.out.println("Height: " + bst.height(bst.root));
        String preOrder = "nlnnlll";
        int depth = bst.depth(preOrder, 0, preOrder.length());
        System.out.println(depth);
    }
}
