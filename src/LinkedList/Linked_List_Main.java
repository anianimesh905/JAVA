package src.LinkedList;

public class Linked_List_Main {
    public static void main(String[] args) {
        Linked_List l = new Linked_List();
        l.insert(10);
        l.insert(20);
        l.insert(30);
        l.insertAtStart(5);
        l.insertAt(1, 25);
        System.out.println("Original list:");
        l.show();

        // Delete
        l.deleteAt(2);
        System.out.println("\nAfter deleting at index 2:");
        l.show();

        // Search
        System.out.println("\nSearch for 20: " + (l.search(20) ? "Found" : "Not Found"));
        System.out.println("Search for 100: " + (l.search(100) ? "Found" : "Not Found"));

        // Update
        l.updateAt(1, 99);
        System.out.println("\nAfter updating index 1 to 99:");
        l.show();
    }
}
