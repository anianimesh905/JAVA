package src.BinaryTree;

import java.util.ArrayList;

public class LevelOrder_BT {

    public ArrayList<ArrayList<Integer>> levelOrder(Node root){
        ArrayList<ArrayList<Integer>> e = new ArrayList<>();

        if(root == null)
            
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<ArrayList<Integer>> result = levelOrder(root);
    }
}
