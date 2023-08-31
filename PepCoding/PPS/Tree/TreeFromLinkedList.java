package Tree;

class Queue {
    Node head, tail;
    int size = 0;
    class Node {
        MyTree.TreeNode value;
        Node next;

        Node(MyTree.TreeNode value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void enqueue(MyTree.TreeNode value) {
        if (head == null) {
            head = new Node(value, null);
            tail = head;
            size += 1;
            return;
        }

        tail.next = new Node(value, null);
        tail = tail.next;
        size += 1;
    }

    public MyTree.TreeNode dequeue() {
        if (head == null) return null;
        Node temp = head;
        head = head.next;
        size -= 1;
        return temp.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
class LinkedList {
    class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node head;

    public void addToEnd(int val) {
        if (head == null) {
            head = new Node(val, null);
            return;
        }

        Node itr = head;
        while(itr.next != null) {
            itr = itr.next;
        }
        itr.next = new Node(val, null);
        return;
    }
}

class MyTree {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    TreeNode root;
    public void constructTree(LinkedList list) {
        if (list == null) return;

        LinkedList.Node itr = list.head;
        Queue queue = new Queue();
        root = new TreeNode(itr.value);
        queue.enqueue(root);
        itr = itr.next;

        while (!queue.isEmpty()) {
            TreeNode parent = queue.dequeue();

            if (itr != null) {
                parent.left = new TreeNode(itr.value);
                queue.enqueue(parent.left);
                itr = itr.next;
            }

            if (itr != null) {
                parent.right = new TreeNode(itr.value);
                queue.enqueue(parent.right);
                itr = itr.next;
            }
        }
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}

public class TreeFromLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addToEnd(10);
        ll.addToEnd(12);
        ll.addToEnd(15);
        ll.addToEnd(25);
        ll.addToEnd(30);
        ll.addToEnd(36);

        MyTree tree = new MyTree();
        tree.constructTree(ll);
        tree.preOrder(tree.root);
    }
}
