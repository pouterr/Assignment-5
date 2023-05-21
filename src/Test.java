public class Test {
    public static void main(String[] args) {
        // Create a new BST
        BST<String, Integer> tree = new BST<>();

        // Test put method
        tree.put("Alice", 1);
        tree.put("Bob", 2);
        tree.put("Charlie", 3);
        tree.put("David", 4);

        // Test size method
        System.out.println("Size: " + tree.size()); // Should print 4

        // Test get method
        System.out.println("Bob's value: " + tree.get("Bob")); // Should print 2

        // Test iterator method
        for (BST<String, Integer>.KeyValue pair : tree.iterator()) {
            System.out.println("Key: " + pair.key + ", Value: " + pair.value);
        }

        // Test delete method
        tree.delete("Charlie");
        System.out.println("Size after deletion: " + tree.size()); // Should print 3
        System.out.println("Charlie's value: " + tree.get("Charlie")); // Should print null

        // Print the BST again after deletion
        for (BST<String, Integer>.KeyValue pair : tree.iterator()) {
            System.out.println("Key: " + pair.key + ", Value: " + pair.value);
        }
    }
}
