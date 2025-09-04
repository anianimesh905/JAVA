package src.LeetCode.LINKEDLIST;

/**
 * LeetCode 876. Middle of the Linked List
 *
 * Problem:
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Example:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5] (middle node = 3)
 *
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6] (middle node = 4, second middle)
 *
 * Goal:
 * - Find the middle node efficiently.
 */
public class LC_876_MiddleOfLinkedList {

    // ✅ Approach 1: Fast & Slow Pointer (O(n), O(1))
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // move 1 step
            fast = fast.next.next;  // move 2 steps
        }
        return slow; // slow is now at the middle
    }

    // ✅ Approach 2: Counting nodes (O(n), O(1))
    public ListNode middleNodeCount(ListNode head) {
        int count = 0;
        ListNode curr = head;

        // count total nodes
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int mid = count / 2; // if even, automatically gives 2nd middle
        curr = head;
        for (int i = 0; i < mid; i++) {
            curr = curr.next;
        }
        return curr;
    }

    // ✅ Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // 🧪 Test the implementation
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        LC_876_MiddleOfLinkedList obj = new LC_876_MiddleOfLinkedList();

        // Approach 1
        System.out.println("Middle (Fast & Slow): " + obj.middleNode(head).val); // ✅ 4

        // Approach 2
        System.out.println("Middle (Counting): " + obj.middleNodeCount(head).val); // ✅ 4
    }
}
