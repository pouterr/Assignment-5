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
        Node parent = null;
        Node current = root;
        boolean hasTwoChildren = false;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                parent = current;
                current = current.left;
            } else if (cmp > 0) {
                parent = current;
                current = current.right;
            } else {
                // Case 1: node to be deleted has no children
                if (current.left == null && current.right == null) {
                    if (parent == null) { // If node to delete is root
                        root = null;
                    } else if (parent.left == current) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
                // Case 2: node to be deleted has one child
                else if (current.left == null) {
                    if (parent == null) { // If node to delete is root
                        root = current.right;
                    } else if (parent.left == current) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                } else if (current.right == null) {
                    if (parent == null) { // If node to delete is root
                        root = current.left;
                    } else if (parent.left == current) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
                // Case 3: node to be deleted has two children
                else {
                    hasTwoChildren = true;
                }

                if (!hasTwoChildren) {
                    size--;
                    return;
                }

                // Find min node in right subtree
                Node minParent = current;
                Node min = current.right;
                while (min.left != null) {
                    minParent = min;
                    min = min.left;
                }

                // Replace current's key and value with min's
                current.key = min.key;
                current.val = min.val;

                // Remove min node
                if (minParent.left == min) {
                    minParent.left = min.right;
                } else {
                    minParent.right = min.right;
                }
                size--;
                return;
            }
        }
    }


    private Node delete(Node x, K key) {

    }

    public Iterable<K> iterator(){

    }
}
