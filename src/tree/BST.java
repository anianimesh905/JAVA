package src.tree;

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
    public static Node delNode(Node root, int x) {
        if (root == null) return root;

        if (x < root.data) {
            root.left = delNode(root.left, x);
        } else if (x > root.data) {
            root.right = delNode(root.right, x);
        } else {
            // Node to delete found

            // Case 1: No left child
            if (root.left == null)
                return root.right;

            // Case 2: No right child
            if (root.right == null)
                return root.left;

            // Case 3: Two children
            Node succ = getSuccessor(root);
            root.data = succ.data;
            root.right = delNode(root.right, succ.data);
        }
        return root;
    }

    // Get inorder successor (smallest value in right subtree)
    public static Node getSuccessor(Node curr) {
        curr = curr.right;
        while (curr != null && curr.left != null)
            curr = curr.left;
        return curr;
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
        delNode(root, 5);
        inorder(root);
    }
}
