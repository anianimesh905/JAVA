package src.BinaryTree;

// Node class represents each node of the binary tree
public class Node {
    int data;
    Node left;
    Node right;

    // Constructor to create a new node with given key
    Node(int key){
        data = key;
        left = null;
        right = null;
    }
}