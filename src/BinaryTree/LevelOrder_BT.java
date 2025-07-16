package src.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder_BT {

    public static ArrayList<ArrayList<Integer>> levelOrder(Node root){
        ArrayList<ArrayList<Integer>> e = new ArrayList<>();

        if(root == null)
            return e;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i < size; i++){
                Node node = q.poll();
                a.add(node.data);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            e.add(a);
        }
        return e;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<ArrayList<Integer>> result = levelOrder(root);

        System.out.println("Level Order Traversal of Tree:");
        for (ArrayList<Integer> level : result) {
            for (int num : level)
                System.out.print(num + " ");
            System.out.println();
        }
    }
}
