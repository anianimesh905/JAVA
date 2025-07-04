package src.Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class MyHashSet {
    public static void main(String args[]) {
        // Creating a HashSet to store Integer values
        HashSet<Integer> set = new HashSet<>();

        // --- Adding elements to the HashSet ---
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // Duplicate value - will be ignored (HashSet stores only unique values)

        // --- Getting the size of the set ---
        System.out.println("size of set is : " + set.size()); // Should print 3 (1, 2, 3)

        // --- Searching for elements in the set ---
        if(set.contains(1)) {
            System.out.println("present"); // 1 is present
        }

        if(!set.contains(6)) {
            System.out.println("absent"); // 6 is not present
        }

        // --- Removing an element from the set ---
        set.remove(1); // Remove value 1
        if(!set.contains(1)) {
            System.out.println("absent"); // Now 1 should be absent
        }

        // --- Printing the whole set ---
        System.out.println(set); // Will print set elements, order is not guaranteed

        // --- Iterating through the set using Iterator ---
        set.add(0); // Adding one more element
        Iterator it = set.iterator(); // Getting iterator object
        while (it.hasNext()) {
            System.out.print(it.next() + ", "); // Printing each element
        }
        System.out.println(); // Move to next line after printing all elements

        // --- Checking if set is empty ---
        if(!set.isEmpty()) {
            System.out.println("set is not empty"); // Should print this since set has elements
        }
    }
}
