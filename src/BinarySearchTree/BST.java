package src.BinarySearchTree;

import java.util.ArrayList;

public class BST {

    // Node class to define the structure of each node in BST
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    // Insert a new value into the BST
    public static Node insert(Node root, int val){
        if(root == null)
            return new Node(val);  // If tree is empty, return new node

        if(root.data > val)
            root.left = insert(root.left, val);  // Go left if value is smaller

        else
            root.right = insert(root.right, val);  // Go right if value is larger or equal

        return root;
    }

    // Inorder traversal: Left -> Root -> Right (Gives sorted order)
    public static void inorder(Node root){
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Search for a value in the BST
    public static boolean search(Node root, int val){
        if (root == null)
            return false;

        if (root.data == val)
            return true;

        if (val < root.data)
            return search(root.left, val);  // Search in left subtree
        else
            return search(root.right, val); // Search in right subtree
    }

    // Delete a node with the given value from the BST
    public static Node delete(Node root, int val) {
        if (root == null) return null;

        if (root.data > val)
            root.left = delete(root.left, val);  // Go to left subtree

        else if (root.data < val)
            root.right = delete(root.right, val); // Go to right subtree

        else {
            // Node found

            // Case 1: Node has no child (leaf)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node has only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Case 3: Node has two children
            // Replace with inorder successor (smallest in right subtree)
            Node is = getSuccessor(root.right);
            root.data = is.data;  // Copy value
            root.right = delete(root.right, is.data);  // Delete the inorder successor
        }

        return root;
    }

    // Helper function to find inorder successor (smallest value in right subtree)
    public static Node getSuccessor(Node root) {
        while(root.left != null)
            root = root.left;
        return root;
    }

    // Print all nodes whose value is between X and Y (inclusive)
    public static void printInRange(Node root, int X, int Y){
        if (root == null)
            return;

        // If current node is in range, print it and explore both subtrees
        if (root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        }
        // If current node is greater than Y, explore only left
        else if(root.data >= Y)
            printInRange(root.left, X, Y);
            // If current node is less than X, explore only right
        else
            printInRange(root.right, X, Y);
    }

    // Print a single root-to-leaf path
    public static void print_Path(ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++)
            System.out.print(path.get(i) + "->");
        System.out.print("NULL");  // End of path
        System.out.println();      // Newline after each path
    }

    // Print all root-to-leaf paths in the tree
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if (root == null)
            return;

        path.add(root.data);  // Add current node to path

        // If it's a leaf node, print the path
        if (root.left == null && root.right == null)
            print_Path(path);
        else {
            // Explore both subtrees
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }

        // Backtrack: remove current node before returning
        path.remove(path.size() - 1);
    }

    // Main method to test BST functions
    public static void main(String[] args) {
        int values[] = {5, 1, 2, 4, 3, 7, 6, 9, 8};
        Node root = null;

        // Insert all values into BST
        for (int value : values) {
            root = insert(root, value);
        }

        // Print inorder traversal
        System.out.print("Inorder traversal: ");
        inorder(root);
        System.out.println();

        // Search for a value
        System.out.println("Is 7 in the tree? " + search(root, 7));

        // Delete a value and print inorder again
        System.out.println("Deleting 5...");
        delete(root, 5);
        System.out.print("Inorder after deletion: ");
        inorder(root);
        System.out.println();

        // Print nodes in range [3, 8]
        int X = 3, Y = 8;
        System.out.println("Nodes in range [" + X + ", " + Y + "]:");
        printInRange(root, X, Y);

        // Print all root-to-leaf paths
        System.out.println("All root-to-leaf paths:");
        printRoot2Leaf(root, new ArrayList<>());
    }
}
