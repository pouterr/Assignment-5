# Assignment-5
# Binary Search Tree in Java

This is a simple implementation of a Binary Search Tree (BST) in Java. It provides basic operations like insert, delete and search. The tree stores key-value pairs, with keys being unique identifiers for each node.

# Class Description

The BST class is parametrized over types K and V, where K is the type of key and V is the type of value to be associated with a given key. Keys are required to be Comparable.

# Class Structure

The BST class includes the following:

An inner Node class which represents individual nodes of the binary search tree.

A KeyValue class which represents key-value pairs and is used when iterating over the tree.

A root node and a size counter.

# Key Methods

`public void put(K key, V value)`:Inserts a key-value pair into the tree. If the key already exists in the tree, the associated value is updated. Otherwise, a new node is created.

`public V get(K key)`:
Returns the value associated with a given key. If the key does not exist in the tree, this method returns null.

`public void delete(K key)`
:Removes the node with the given key from the tree. If the key does not exist in the tree, this method has no effect. If the node to be deleted has two children, this method uses the "replace with inorder successor" strategy (i.e., replaces the key and value of the node to be deleted with the key and value of the minimum node in its right subtree).

`public Iterable<KeyValue> iterator()`:
Returns an Iterable of KeyValue pairs. This method uses an inorder traversal to collect key-value pairs, so the returned Iterable represents the pairs in sorted order of their keys.

`private void inorder(Node x, List<KeyValue> pairs)`:
Performs an inorder traversal of the tree rooted at a given node, collecting key-value pairs in the process. This method is used internally by the iterator() method.

# Usage

Create a BST object and use the put, get and delete methods for insertion, retrieval, and deletion operations respectively. The iterator() method can be used to obtain an Iterable of KeyValue pairs for iterating over the tree in sorted order of keys.
