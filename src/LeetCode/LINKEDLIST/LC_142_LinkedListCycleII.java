package src.LeetCode.LINKEDLIST;

/**
 * LeetCode 142. Linked List Cycle II
 *
 * Problem Statement:
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * A cycle exists if there is a node in the list that can be reached again
 * by continuously following the next pointer.
 *
 * Example:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: Node with value 2
 * Explanation: There is a cycle in the linked list where the tail connects to the 1st node.
 *
 * Goal:
 * Return the node where the cycle begins, or null if there is no cycle.
 *
 * Approach (Floyd’s Tortoise & Hare Algorithm):
 * 1. Use slow and fast pointers to detect if a cycle exists.
 * 2. If no cycle → return null.
 * 3. If cycle exists, move one pointer to head and keep the other at meeting point.
 * 4. Move both pointers one step at a time.
 * 5. The node where they meet is the start of the cycle.
 */

public class LC_142_LinkedListCycleII {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Function to detect the start of the cycle
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // cycle detected
                // Step 2: Find entry point
                ListNode pointer = head;
                while (pointer != slow) {
                    pointer = pointer.next;
                    slow = slow.next;
                }
                return pointer; // start of cycle
            }
        }
        return null; // no cycle
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_142_LinkedListCycleII obj = new LC_142_LinkedListCycleII();

        // Create a linked list with a cycle
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // creates cycle at node with value 2

        ListNode cycleStart = obj.detectCycle(head);
        System.out.println(cycleStart != null ? cycleStart.val : "No cycle"); // Output: 2

        // Create a linked list without cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(obj.detectCycle(head2)); // Output: null
    }
}

/**
 * Time Complexity:
 * - Cycle detection: O(n)
 * - Finding entry point: O(n)
 * Overall: O(n)
 *
 * Space Complexity:
 * - Only using pointers: O(1)
 */
