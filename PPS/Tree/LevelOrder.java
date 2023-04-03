package Tree;

class Linked {
    Node head;
    Node tail;
    int size = 0;
    class Node {
        BinaryTree.Node value;
        Node next;

        Node (BinaryTree.Node value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addToEnd(BinaryTree.Node val) {
        if (head == null) {
            head =  new Node(val, null);
            size += 1;
            tail = head;
            return;
        }

        Node itr = head;
        while (itr.next != null) {
            itr = itr.next;
        }

        itr.next = new Node(val, null);
        tail = itr.next;
        size += 1;
    }

    public void removeFromStart() {
        if (head == null) {
            System.out.println("NO REMOVE");
            return;
        }

        head = head.next;
        size -= 1;
    }
}
class BinaryTree {
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

    public void levelOrder() throws Exception {
        if (root == null) throw new Exception("NO TREE");

        Linked ll = new Linked();
        Node itr = root;
        ll.addToEnd(itr);

        while (ll.size != 0) {
            level += 1;
            itr = ll.head.value;
            System.out.print(itr.value + " ");
            if (itr.left != null) {
                ll.addToEnd(itr.left);
            }

            if (itr.right != null) {
                ll.addToEnd(itr.right);
            }

            ll.removeFromStart();
        }
    }

    public void levelSpiral() {
        if (root == null) {
            return;
        }

        Linked ll = new Linked();
        Node itr = root;
        ll.addToEnd(itr);

        String goTo = "right";

        while (ll.size != 0) {
            itr = ll.head.value;
            System.out.print(itr.value + " ");

            if (goTo == "right") {
                if (itr.right != null) {
                    ll.addToEnd(itr.right);
                }

                if (itr.left != null) {
                    ll.addToEnd(itr.left);
                }
                goTo = "left";
            } else {
                if (itr.left != null) {
                    ll.addToEnd(itr.left);
                }

                if (itr.right != null) {
                    ll.addToEnd(itr.right);
                }
                goTo = "right";
            }
            ll.removeFromStart();
        }
    }

    public void diagonalPrint() {
        if (root == null) {
            return;
        }

        Node itr = root;

        Node parent = itr;
        while (parent != null) {
            System.out.print(itr.value + " ");
            if (itr.right != null) {
                itr = itr.right;
            } else {
                itr = parent.left;
                parent = itr;
            }
        }
    }

    public void boundaryPrint(Node itr) {
        if (itr == null) return;

        System.out.println(itr.value);
        leaveNode(itr);
        System.out.println();
        leftNode(itr.left);
        System.out.println();
        rightNode(itr.right);
    }

    public void leftNode(Node itr) {
        if (itr == null) return;
        if (itr.left == null && itr.right == null) return;

        leftNode(itr.left);
        System.out.print(itr.value + " ");
    }

    public void rightNode(Node itr) {
        if (itr == null) return;
        if (itr.left == null && itr.right == null) return;

        rightNode(itr.right);
        System.out.print(itr.value + " ");
    }

    public void leaveNode(Node itr) {
        if (itr == null) return;

        leaveNode(itr.left);

        if(itr.left == null && itr.right == null) {
            System.out.print(itr.value + " ");
        }

        leaveNode(itr.right);
    }
}

public class LevelOrder {
    public static void main (String args[]) throws Exception {
        BinaryTree bst = new BinaryTree();
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
        bst.boundaryPrint(bst.root);
        //bst.diagonalPrint();

        //bst.levelOrder();
        //System.out.println();
        //bst.levelSpiral();


        /*BinaryTree bst2 = new BinaryTree();
        bst2.addNode(4);
        bst2.addNode(3);
        bst2.addNode(2);
        bst2.addNode(1);

        System.out.println();
        bst2.levelOrder();
        System.out.println();
        bst2.levelSpiral();*/
    }
}
