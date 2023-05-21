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
        if (root == null) {
            root = new Node(key, value);
            size++;
        } else {
            Node current = root;
            while (true) {
                int cmp = key.compareTo(current.key);
                if (cmp < 0) {
                    if (current.left == null) {
                        current.left = new Node(key, value);
                        size++;
                        return;
                    } else {
                        current = current.left;
                    }
                } else if (cmp > 0) {
                    if (current.right == null) {
                        current.right = new Node(key, value);
                        size++;
                        return;
                    } else {
                        current = current.right;
                    }
                } else {
                    // Update the value if key already exists
                    current.val = value;
                    return;
                }
            }
        }
    }


    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {

    }

    public Iterable<K> iterator(){

    }
}
