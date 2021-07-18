class MyHashMap {
    
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

  /** Initialize your data structure here. */
  public MyHashMap() {
      initialize(10);
  }
  
  public void rehash(){
      LinkedList<Node>[] temp = this.Buckets;
      initialize((int) this.bucketLen *2);

      for(int i=0; i<temp.length; i++){
          LinkedList<Node> group = temp[i];
          int size = group.size();
          while(size-- >0){
              Node node = group.removeFirst();
              put(node.key, node.value);
          }
      }
  }
  
  /** value will always be non-negative. */
  public void put(int key, int value) {
      boolean res = containsKey(key);
      LinkedList<Node> group = getGroup(key);

      if(res){
          group.getFirst().value = value;
      }
      else{
          Node node = new Node(key, value);
          group.addLast(node);
          this.totalNoOfNodes++;
          double lambda = group.size() / (1.0 * this.bucketLen);

          if(lambda > 0.4)
              rehash();
      }
  }
  
  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  public int get(int key) {
       boolean res = containsKey(key);
      LinkedList<Node> group = getGroup(key);
      return res ? group.getFirst().value : -1;
  }
  
  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
      boolean res = containsKey(key);
    LinkedList<Node> group = getGroup(key);
      if(res){
          this.totalNoOfNodes--;
          group.removeFirst();
      } 
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

/**
* Your MyHashMap object will be instantiated and called as such:
* MyHashMap obj = new MyHashMap();
* obj.put(key,value);
* int param_2 = obj.get(key);
* obj.remove(key);
*/