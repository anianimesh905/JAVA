// 🚀 QUESTION:
// Write a Java program to perform the three standard depth-first traversals of a Binary Tree:
// ➤ Preorder Traversal
// ➤ Inorder Traversal
// ➤ Postorder Traversal

// ✅ EXPLANATION:
// A Binary Tree is a tree data structure in which each node has at most two children: left and right.
// Traversal means visiting all the nodes of the tree in a specific order.

// 🔁 There are 3 common types of DFS (Depth-First Search) tree traversals:
// 1. Preorder Traversal:       Root ➝ Left ➝ Right
// 2. Inorder Traversal:        Left ➝ Root ➝ Right
// 3. Postorder Traversal:      Left ➝ Right ➝ Root

// In this code:
// - We define a basic binary tree using `Node` class.
// - We use recursive methods to implement each traversal.
// - We store the traversal results in an ArrayList and print them.

package src.BinaryTree;
import java.util.ArrayList;
import java.util.List;

public class BT {

    // 🔸 Preorder Traversal (Root ➝ Left ➝ Right)
    static void preorderTraversal(Node root, List<Integer> arr){
        if(root == null)
            return;

        arr.add(root.data);                        // Visit root
        preorderTraversal(root.left, arr);         // Traverse left subtree
        preorderTraversal(root.right, arr);        // Traverse right subtree
    }

    static ArrayList<Integer> preorder(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        preorderTraversal(root, arr);
        return arr;
    }

    // 🔸 Inorder Traversal (Left ➝ Root ➝ Right)
    static void inorderTraversal(Node root, List<Integer> arr){
        if(root == null)
            return;

        inorderTraversal(root.left, arr);          // Traverse left subtree
        arr.add(root.data);                        // Visit root
        inorderTraversal(root.right, arr);         // Traverse right subtree
    }

    static ArrayList<Integer> inorder(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        inorderTraversal(root, arr);
        return arr;
    }

    // 🔸 Postorder Traversal (Left ➝ Right ➝ Root)
    static void postorderTraversal(Node root, List<Integer> arr){
        if(root == null)
            return;

        postorderTraversal(root.left, arr);        // Traverse left subtree
        postorderTraversal(root.right, arr);       // Traverse right subtree
        arr.add(root.data);                        // Visit root
    }

    static ArrayList<Integer> postorder(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        postorderTraversal(root, arr);
        return arr;
    }

    // 🔹 Main function to test the tree traversal methods
    public static void main(String[] args) {
        // Construct the binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \
        //    4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Preorder traversal output
        System.out.println("Preorder: ");
        ArrayList<Integer> g = preorder(root);
        for (int i : g){
            System.out.print(i + " ");
        }
        System.out.println();

        // Inorder traversal output
        System.out.println("Inorder: ");
        ArrayList<Integer> e = inorder(root);
        for (int i : e){
            System.out.print(i + " ");
        }
        System.out.println();

        // Postorder traversal output
        System.out.println("Postorder: ");
        ArrayList<Integer> f = postorder(root);
        for (int i : f){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
