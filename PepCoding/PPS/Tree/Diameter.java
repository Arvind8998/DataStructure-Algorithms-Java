package Tree;

import java.util.Scanner;

class MyQueue {
    Node head, tail;
    int size = 0;
    class Node {
        TreeNodes.Node value;
        Node next;

        Node(TreeNodes.Node value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void enqueue(TreeNodes.Node root) {
        if (head == null) {
            head = new Node(root, null);
            tail = head;
            size += 1;
            return;
        }

        tail.next = new Node(root, null);
        tail = tail.next;
        size += 1;
    }

    public TreeNodes.Node dequeue() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        size -= 1;
        return temp.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

class TreeNodes {
      class Node {
          private int data;
          Node left, right;

          Node(int data) {
              this.data = data;
              left = right = null;
          }
      }

      Node root;

      public void addNode(int value) {
          if (root == null) {
              root = new Node(value);
              return;
          }

          Node itr = root;
          while (true) {
              Node newNode = new Node(value);
              if (value < itr.data) {
                  if (itr.left == null) {
                      itr.left = newNode;
                      return;
                  }

                  itr = itr.left;
              } else {
                  if (itr.right == null) {
                      itr.right = newNode;
                      return;
                  }
                  itr = itr.right;
              }
          }
      }

      public void inOrder(Node root) {
          if (root != null) {
              inOrder(root.left);
              System.out.print(root.data + " ");
              inOrder(root.right);
          }
      }

      public void levelOrder() {
          if (root == null) return;

          MyQueue queue = new MyQueue();
          Node itr = root;
          queue.enqueue(itr);

          while (!queue.isEmpty()) {
              itr = queue.dequeue();
              System.out.print(itr.data + " ");
              if (itr.left != null) {
                  queue.enqueue(itr.left);
              }

              if (itr.right != null) {
                  queue.enqueue(itr.right);
              }
          }

      }

      public int diameter(Node root) {
          int[] diameter = new int[1];
          diameterWrapper(root, diameter);
          return diameter[0];
      }
      public int diameterWrapper(Node root, int[] diameter) {
          if (root == null) return 0;

          int left = diameterWrapper(root.left, diameter);
          int right = diameterWrapper(root.right, diameter);

          diameter[0] = Math.max(diameter[0], left+right);
          return Math.max(left, right) + 1;
      }
}

public class Diameter {
    public static void main(String[] args) {
        TreeNodes tree = new TreeNodes();
        Scanner keyboard = new Scanner(System.in);
        int nodes = keyboard.nextInt();

        for (int i = 0; i < nodes; i++) {
            tree.addNode(keyboard.nextInt());
        }

        tree.levelOrder();
        System.out.println(tree.diameter(tree.root));
    }
}
