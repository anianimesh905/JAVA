package src.LeetCode.LINKEDLIST;

/**
 * LeetCode 237. Delete Node in a Linked List
 *
 * Problem:
 * Write a function to delete a node in a singly-linked list.
 * You are given only access to that node.
 *
 * Input:
 * head = [4,5,1,9], node = 5
 * Output:
 * [4,1,9]
 *
 * Input:
 * head = [4,5,1,9], node = 1
 * Output:
 * [4,5,9]
 *
 * Note:
 * - The input node is guaranteed not to be the last node.
 *
 * Goal:
 * - Modify the node so that it gets "deleted" without direct access to head.
 */
public class LC_237_DeleteNodeInLinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    /**
     * Approach:
     * - Copy the value of the next node into the current node.
     * - Skip the next node by linking current.next = current.next.next.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;     // copy next node's value
        node.next = node.next.next;   // unlink next node
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_237_DeleteNodeInLinkedList obj = new LC_237_DeleteNodeInLinkedList();

        // LinkedList: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Delete node 5
        obj.deleteNode(head.next);

        // Print list after deletion
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");  // Expected: 4 1 9
            curr = curr.next;
        }
    }
}
