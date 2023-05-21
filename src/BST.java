import java.util.ArrayList;
import java.util.List;

/**
 * Binary Search Tree (BST) class that provides standard operations such as insertion, deletion and search.
 *
 * @param <K> Key - unique identifier for each Node
 * @param <V> Value - data to be associated with a given key
 */
public class BST<K extends Comparable<K>, V>{
    private Node root;
    private int size;

    /**
     * Inner class for Node
     */
    private class Node{
        private K key;
        private V val;
        private Node left,right;
        public Node(K key,V val){
            this.key = key;
            this.val = val;
        }
    }

    /**
     * Class representing Key-Value pairs, useful for iterating over the tree
     */
    public class KeyValue {
        public K key;
        public V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Returns the number of nodes in the tree.
     */
    public int size() {
        return size;
    }

    /**
     * Inserts a key-value pair into the tree. If the key already exists in the tree, the associated
     * value is updated. Otherwise, a new node is created.
     *
     * @param key   The key of the node to be inserted.
     * @param value The value to be associated with the key.
     */
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

    /**
     * Returns the value associated with a given key. If the key does not exist in the tree, this
     * method returns null.
     *
     * @param key The key whose associated value is to be returned.
     * @return The value associated with the provided key, or null if the key does not exist in the tree.
     */
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

    /**
     * Removes the node with the given key from the tree. If the key does not exist in the tree, this
     * method has no effect. If the node to be deleted has two children, this method uses the
     * "replace with inorder successor" strategy (i.e., replaces the key and value of the node to be
     * deleted with the key and value of the minimum node in its right subtree).
     *
     * @param key The key of the node to be deleted.
     */
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


    /**
     * Returns an Iterable of KeyValue pairs. This method uses an inorder traversal to collect
     * key-value pairs, so the returned Iterable represents the pairs in sorted order of their keys.
     *
     * @return An Iterable of KeyValue pairs in sorted order of their keys.
     */
    public Iterable<KeyValue> iterator() {
        List<KeyValue> pairs = new ArrayList<>();
        inorder(root, pairs);
        return pairs;
    }

    /**
     * Performs an inorder traversal of the tree rooted at a given node, collecting key-value pairs
     * in the process. This method is used internally by the iterator() method.
     *
     * @param x     The root node of the subtree to be traversed.
     * @param pairs The list in which to store the collected key-value pairs.
     */
    private void inorder(Node x, List<KeyValue> pairs) {
        if (x == null) return;
        inorder(x.left, pairs);
        pairs.add(new KeyValue(x.key, x.val));
        inorder(x.right, pairs);
    }


}
