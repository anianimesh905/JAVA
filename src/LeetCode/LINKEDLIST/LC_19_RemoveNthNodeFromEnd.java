package src.LeetCode.LINKEDLIST;

/**
 * LeetCode 19. Remove Nth Node From End of List
 *
 * Problem Statement:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Goal:
 * Efficiently remove the Nth node from the end in one pass.
 *
 * Approaches:
 * --------------------------------------------------------------------
 * 1. Two-Pointer Technique (Optimal, O(n)):
 *    - Maintain two pointers: fast and slow.
 *    - Move fast n steps ahead first.
 *    - Then move both slow and fast until fast reaches the end.
 *    - Now, slow is at the node just before the target → remove it.
 *
 * 2. Length Calculation (Brute Force, O(n)):
 *    - First calculate total length of the list.
 *    - Find (len - n)th node and remove its next node.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LC_19_RemoveNthNodeFromEnd {

    // ---------------- Approach 1: Two-Pointer ----------------
    public ListNode removeNthFromEnd_TwoPointer(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead to maintain a gap
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the target node
        slow.next = slow.next.next;

        return dummy.next;
    }

    // ---------------- Approach 2: Length Calculation ----------------
    public ListNode removeNthFromEnd_Length(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = 0;
        ListNode temp = head;

        // Step 1: Calculate total length
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: Find (len-n)th node
        length -= n;
        temp = dummy;
        while (length > 0) {
            length--;
            temp = temp.next;
        }

        // Step 3: Remove the target node
        temp.next = temp.next.next;

        return dummy.next;
    }

    // ---------------- Test Both Approaches ----------------
    public static void main(String[] args) {
        LC_19_RemoveNthNodeFromEnd obj = new LC_19_RemoveNthNodeFromEnd();

        // Create test case: [1,2,3,4,5]
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        // Two-Pointer Approach
        ListNode result1 = obj.removeNthFromEnd_TwoPointer(head, 2);
        printList(result1); // Expected: 1 -> 2 -> 3 -> 5

        // Another test: [1,2], remove last element
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode result2 = obj.removeNthFromEnd_Length(head2, 1);
        printList(result2); // Expected: 1
    }

    // Utility function to print list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }
}

/**
 * Time Complexity:
 * - Two-Pointer: O(n)
 * - Length Calculation: O(n)
 *
 * Space Complexity:
 * - O(1) extra space
 */
