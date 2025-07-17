package src.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {

    // Function to calculate height using level order traversal (BFS)
    static int heightOfTree(Node root){
        if (root == null)
            return 0; // Edge case: if tree is empty, height = 0

        Queue<Node> q = new LinkedList<>(); // Queue for level-order traversal
        int level = 0; // To count number of levels (height)

        q.add(root); // Start from root node

        // Traverse while queue is not empty
        while(!q.isEmpty()){
            int size = q.size(); // Number of nodes at current level

            // Process all nodes at this level
            for(int i = 0; i < size; i++){
                Node front = q.poll(); // Remove the front node from queue

                // Add left child if it exists
                if (front.left != null) {
                    q.add(front.left);
                }

                // Add right child if it exists
                if (front.right != null) {
                    q.add(front.right);
                }
            }

            // After processing one full level, increment level counter
            level++;
        }

        return level; // Total levels = height
    }

    public static void main(String[] args) {
        // Construct the tree:
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
           /
          8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);

        int max = heightOfTree(root);

        System.out.println(max); // Output: 4
    }
}
