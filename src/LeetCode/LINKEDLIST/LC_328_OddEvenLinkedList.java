package src.LeetCode.LINKEDLIST;

/**
 * LeetCode 328. Odd Even Linked List
 *
 * Problem Statement:
 * Given the head of a singly linked list, group all the nodes with odd indices together
 * followed by the nodes with even indices, and return the reordered list.
 *
 * Note:
 * - The first node is considered index 1 (odd), the second node index 2 (even), etc.
 * - The relative order inside odd and even groups should be preserved.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 *
 * Example 2:
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 *
 * Goal:
 * Rearrange the list such that all odd-indexed nodes come before even-indexed nodes.
 *
 * Approach:
 * 1. Use two pointers: one for odd nodes, one for even nodes.
 * 2. Connect odd.next to odd.next.next and even.next to even.next.next.
 * 3. Finally, attach the last odd node to the head of the even list.
 */

public class LC_328_OddEvenLinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        // odd and even pointers
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // keep reference to connect later

        // Rearrange odd and even
        while (even != null && even.next != null) {
            odd.next = even.next;  // link next odd
            odd = odd.next;        // move odd pointer
            even.next = odd.next;  // link next even
            even = even.next;      // move even pointer
        }

        // connect last odd to head of even list
        odd.next = evenHead;

        return head;
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_328_OddEvenLinkedList obj = new LC_328_OddEvenLinkedList();

        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode result1 = obj.oddEvenList(head1);
        printList(result1); // Output: 1 -> 3 -> 5 -> 2 -> 4

        // Example 2
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(5);
        head2.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next.next = new ListNode(7);
        ListNode result2 = obj.oddEvenList(head2);
        printList(result2); // Output: 2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4
    }

    // Utility function to print linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}

/**
 * Time Complexity:
 * - Single pass through list: O(n)
 *
 * Space Complexity:
 * - O(1), no extra data structures, only pointers used.
 */
