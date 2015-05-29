package biz.avelit.map;

public class SimpleHashMap {

  private final Integer CAPACITY = 100;
  private Integer size;
  private Node[] map;

  public SimpleHashMap (){
    //List<Node> map = new ArrayList<Node>(CAPACITY);
    // its faster
    map = new Node[CAPACITY];
    size = 0;
    // no lists for collision, put objects to next cel
    // no resizing!!!!!!!!!!!!!!! DO NOT PUT OBJECTS TO THE END
  }

  public void put(Integer key, Long value) {
    Node node = getNode(key);
    if (node == null) {
      Node newNode = new Node(key,value);
      put(newNode);
    } else {
      node.setValue(value);
    }
  }

  private boolean put(Node node) {
    Integer hash = getLocalHash(node.getKey());
    while (hash < CAPACITY) {
      if (map[hash] == null) {
        map[hash] = node;
        size++;
        return true;
      }
      hash++;
    }
    return false;
  }

  private Node getNode(Integer key) {
    Integer hash = getLocalHash(key);
    while (hash < CAPACITY) {
      Node node = map[hash];
      if (node == null) {return null;}
      if (key.equals(node.getKey())) {return node;}
      hash++;
    }
    return null;
  }

  private int getLocalHash(Integer key) {
    return key.hashCode() % CAPACITY;
  }

  public Integer size() {
    return size;
  }

  public Long get(Integer key) {
    Node node = getNode(key);
    if (node == null) {
      return null;
    } else {
      return node.getValue();
    }
  }

  class Node {
    private Integer key;
    private Long value;

    public Node(Integer key, Long value) {
      this.key = key;
      this.value = value;
    }

    public Integer getKey() {
      return key;
    }

    public void setKey(Integer key) {
      this.key = key;
    }

    public Long getValue() {
      return value;
    }

    public void setValue(Long value) {
      this.value = value;
    }
  }
}
