public class HashMap {
    public class Node {
        int value;
        int key;
        Node next = null;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int NoOfElements = 0;

    private void addLast(Node node) {
        if (head == null)
            head = tail = node;

        else
            this.tail.next = node;
            this.tail = node;
    }

    private void addLast(Node node) {
        if (head == null)
            head = tail = node;

        else
            this.tail.next = node;
            this.tail = node;
    }
}
