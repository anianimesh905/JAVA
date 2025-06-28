package src.linked_list;

public class Linked_List {
    Node head;

    // Insert at end
    public void insert(int data) {
        Node node = new Node();
        node.data = data;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    // Insert at start
    public void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    // Insert at specific index
    public void insertAt(int index, int data) {
        if (index == 0) {
            insertAtStart(data);
            return;
        }

        Node node = new Node();
        node.data = data;

        Node n = head;
        for (int i = 0; i < index - 1; i++) {
            if (n == null) return;
            n = n.next;
        }

        node.next = n.next;
        n.next = node;
    }

    // Delete at specific index
    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }

        Node n = head;
        for (int i = 0; i < index - 1; i++) {
            if (n == null || n.next == null) return;
            n = n.next;
        }

        n.next = n.next.next;
    }

    // Search for a value
    public boolean search(int value) {
        Node n = head;
        while (n != null) {
            if (n.data == value)
                return true;
            n = n.next;
        }
        return false;
    }

    // Update value at a specific index
    public void updateAt(int index, int newData) {
        Node n = head;
        for (int i = 0; i < index; i++) {
            if (n == null) return;
            n = n.next;
        }
        if (n != null)
            n.data = newData;
    }

    // Display the list
    public void show() {
        Node n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }
}
