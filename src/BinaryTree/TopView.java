package src.BinaryTree;

import java.util.*;

// Class to represent a pair of node and its horizontal distance (HD)
class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopView {

    // Function to print the Top View of the binary tree
    static void topView(Node root){
        if (root == null) {
            System.out.println("Tree is empty...");
            return;
        }

        // Map to store the first node at each horizontal distance (HD)
        Map<Integer, Integer> topMap = new TreeMap<>();

        // Queue for level order traversal with HD tracking
        Queue<Pair> q = new LinkedList<>();

        // Start with root node at horizontal distance 0
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair current = q.poll();
            Node currNode = current.node;
            int hd = current.hd;

            // If horizontal distance is not yet present in map,
            // this is the topmost node for that HD
            if (!topMap.containsKey(hd)) {
                topMap.put(hd, currNode.data);
            }

            // Add left child with HD - 1
            if (currNode.left != null) {
                q.add(new Pair(currNode.left, hd - 1));
            }

            // Add right child with HD + 1
            if (currNode.right != null) {
                q.add(new Pair(currNode.right, hd + 1));
            }
        }

        // Print the top view from left to right (TreeMap keeps keys sorted)
        System.out.print("Top View: ");
        for (int value : topMap.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the binary tree
        /*
                    1
                  /
                 2
                / \
               4   5
                    \
                     8
                      \
                       9
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(8);
        root.left.right.right.right = new Node(9);

        topView(root); // Expected Output: 4 2 1 3 8
    }
}
