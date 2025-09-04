package src.LeetCode.LINKEDLIST;

/**
 * LeetCode 206. Reverse Linked List
 *
 * Problem:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Goal:
 * - Reverse the list efficiently using iteration or recursion.
 */
public class LC_206_ReverseLinkedList {

    // ✅ Approach 1: Iterative (O(n), O(1))
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // save next
            curr.next = prev;          // reverse pointer
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }
        return prev; // new head
    }

    // ✅ Approach 2: Recursive (O(n), O(n) stack space)
    public ListNode reverseListRecursive(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // reverse the rest of the list
        ListNode newHead = reverseListRecursive(head.next);

        // fix pointers
        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    // ✅ Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // 🧪 Test the implementation
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        LC_206_ReverseLinkedList obj = new LC_206_ReverseLinkedList();

        // Test Iterative
        ListNode newHead1 = obj.reverseListIterative(head);
        System.out.print("Reversed (Iterative): ");
        printList(newHead1); // ✅ 5 -> 4 -> 3 -> 2 -> 1

        // Recreate linked list for recursive test
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Test Recursive
        ListNode newHead2 = obj.reverseListRecursive(head);
        System.out.print("Reversed (Recursive): ");
        printList(newHead2); // ✅ 5 -> 4 -> 3 -> 2 -> 1
    }

    // Helper function to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
