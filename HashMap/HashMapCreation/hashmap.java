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
    private int totalNoOfNodes = 0;

    private void initialize(int size) {
        this.bucketLen = size;
        this.Buckets = new LinkedList[bucketLen];

        for (int i = 0; i < size; i++)
            Buckets[i] = new LinkedList<>();
        this.totalNoOfNodes = 0;
    }

    hashMap(){
        initialize(10);
    }

    public ArrayList<Integer> keySet(){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<this.bucketLen; i++){
            LinkedList<Node> group = this.Buckets[i];
            int size = group.size();

            while(size-- > 0){
                Node node = group.removeFirst();
                ans.add(node.key);
                group.addLast(node);
            }
        }
        return ans;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int tempSize = this.totalNoOfNodes;

        for(int i=0; i<this.bucketLen; i++){
            LinkedList<Node> group = this.Buckets[i];
            int size = group.size();

            while(size -- > 0){
                Node node = group.removeFirst();
                sb.append(node.key + "=" + node.value);
                group.addLast(node);
                if(--tempSize !=0)
                    sb.append(",");
            }
        }
        sb.toString("}");
        return sb.toString();
    }

    public int size(){
        return this.totalNoOfNodes;
    }

    public void rehash(){
        LinkedList<Node>[] temp = this.Buckets;
        initialize((int) this.bucketLen *2);

        for(int i=0; i<temp.length; i++){
            LinkedList<Node> group = this.temp[i];
            int size = group.size();
            while(size-- >0){
                Node node = group.removeFirst();
                put(node.key, node.value;)
            }
        }
    }

    public Integer put(Integer key, Integer value) {
        boolean res = containsKey(key);
        LinkedList<Node> group = getGroup(key);

        if(res){
            group.getFirst().value = value;
        }
        else{
            Node node = new Node(key, value);
            group.addLast(key);
            this.totalNoOfNodes++;
            double lambda = group.size() / (1.0 * this.bucketLen);

            if(lambda > 0.4)
                rehash();
        }
    }

    public void putIfAbsent(Integer key, Integer defaultValue){
        boolean res = containsKey(key);
        LinkedList<Node> group = getGroup(key);
        if(!res){
            Node node = new Node(key, defaultValue);
            group.addLast(node);
            this.totalNoOfNodes++;
        }
    }

    public Integer get(Integer key) {
        boolean res = containsKey(key);
        LinkedList<Node> group = getGroup(key);
        return res ? group.getFirst().value : null;
    }

    public Integer getorDefault(Integer key, Integer defaultValue) {
      Integer val = get(key);
      return val !=null ? val : defaultValue;
    }

    public Integer remove(Integer key) {
      boolean res = containsKey(key);
      LinkedList<Node> group = getGroup(key);
        if(res){
            this.totalNoOfNodes--;
            return group.removeFirst().value;
        } 
        return null;
    }

    public boolean containsKey(Integer key) {
        LinkedList<Node> group = getGroup(key);
        int gs = group.size();
        boolean res = false;

        while (gs-- > 0) {
            if (group.getFirst().key.equals(key)) {
                res = true;
                break;
            }
            group.addLast(group.removeFirst());
        }
        return res;
    }

    private LinkedList<Node> getGroup(Integer key) {
        int hc = getHashCode(key);
        return Buckets[hc];
    }

    private int getHashCode(Integer key) {
        return Math.abs(key.hashCode()) % bucketLen;
    }

}
