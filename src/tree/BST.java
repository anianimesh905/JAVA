package src.tree;

import java.sql.SQLOutput;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){      //inserting key
        if(root == null)
            return new Node(val);

        if(root.data > val)
            root.left = insert(root.left, val);

        else
            root.right = insert(root.right, val);

        return root;
    }

    public static void inorder(Node root){      //inorder traversal
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int val){
        if (root == null)
            return false;

        if (root.data == val)
            return true;

        if (val < root.data)
            return search(root.left, val);

        else
            return search(root.right, val);
    }

    // Delete a node with value x from BST
    public static Node delete(Node root, int val) {

        if(root.data > val)
            root.left = delete(root.left, val);

        else if(root.data < val)
            root.right = delete(root.right, val);

        else{
            // Case 1: No child
            if (root.left == null && root.right == null) {
                root = null;
                return root;
            }

            // Case 2: 1 child
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            // Case 3: 2 child
            Node is = getSuccessor(root.right);
            root.data = is.data;
            root.right = delete(root.right, is.data); // Deleting the duplicate and update using root.right =
        }

        return root;
    }

    // Get inorder successor (smallest value in right subtree)
    public static Node getSuccessor(Node root) {
        while(root.left != null)
            root = root.left;
        return root;
    }

    public static void printInRange(Node root, int X, int Y){
        if (root == null)
            return;

        if (root.data >= X && root.data <= Y)
        {
            printInRange(root.left, X, Y);
            System.out.print(root.data+" ");
            printInRange(root.right, X, Y);
        }
        else if(root.data >= Y)
            printInRange(root.left, X, Y);
        else
            printInRange(root.right, X, Y);
    }

    public static void main(String[] args) {
        int values[] = {5,1,2,4,3,7,6,9,8};
        Node root = null;

//        for (int i = 0; i<values.length; i++){
//            root = insert(root, values[i]);
//        }

        for (int value : values) {      // enhanced for loop
            root = insert(root, value);
        }

        inorder(root);
        System.out.println();

        System.out.println(search(root,7));
        delete(root, 5);
        inorder(root);

        int X = 3;
        int Y = 8;
        System.out.println();
        System.out.println("In range of "+X+" and "+Y+" ");
        printInRange(root, X, Y);
    }
}
