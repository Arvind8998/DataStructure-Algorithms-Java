import java.util.LinkedList;

public class hashmap {
    private class Node {
        Integer key = null;
        Integer value = null;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] Buckets;
    private int bucketLen = 0;
    private int TotalNoOfNodes = 0;

    private void initialize(int size) {
        bucketLen = size;
        Buckets = new LinkedList[bucketLen];

        for (int i = 0; i < size; i++)
            Buckets[i] = new LinkedList<>();
        TotalNoOfNodes = 0;
    }

    hashMap(){
        initialize(10);
    }

    public boolean containsKey(Integer key) {
        LinkedList<Node> group = getGroup(key);
        int gs = group.size();
        boolean res = false;

        while (gs-- > 0) {
            if (group.getFirst().key == key) {
                res = true;
                break;
            }
            group.addLast(group.removeFirst());
        }
        return res;
    }

    private LinkedList<Node> getGroup(Integer key) {
        int hc = key.hashCode();
        return Buckets[hc];
    }

    private int getHashCode(Integer key) {
        return Math.abs(key.hashCode()) % bucketLen;
    }

}
