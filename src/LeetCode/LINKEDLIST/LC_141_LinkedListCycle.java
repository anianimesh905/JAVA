package src.LeetCode.LINKEDLIST;

/**
 * LeetCode 141. Linked List Cycle
 *
 * Problem Statement:
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * A cycle exists if there is some node in the list that can be reached again
 * by continuously following the next pointer.
 *
 * Example:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list where the tail connects to the 1st node.
 *
 * Goal:
 * Return true if there is a cycle, otherwise false.
 *
 * Approach:
 * - Use Floyd’s Tortoise & Hare Algorithm (fast & slow pointers).
 * - Slow moves 1 step, fast moves 2 steps.
 * - If they ever meet, a cycle exists.
 * - If fast or fast.next becomes null, no cycle exists.
 */

public class LC_141_LinkedListCycle {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Detect cycle using Floyd’s Tortoise & Hare Algorithm
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Traverse until fast or fast.next becomes null
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            if (slow == fast) {        // cycle detected
                return true;
            }
        }
        return false; // no cycle
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_141_LinkedListCycle obj = new LC_141_LinkedListCycle();

        // Create a linked list with a cycle
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // creates cycle

        System.out.println(obj.hasCycle(head)); // Output: true
    }
}
