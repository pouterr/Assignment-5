public class BST<K extends Comparable<K>, V>{
    private Node root;
    private int size;
    private class Node{
        private K key;
        private V val;
        private Node left,right;
        public Node(K key,V val){
            this.key = key;
            this.val = val;
        }
    }

    public class KeyValue {
        public K key;
        public V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    public V get(K key){

    }

    public void delete(K key){

    }

    public Iterable<K> iterator(){

    }
}
