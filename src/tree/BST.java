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
    }
}
