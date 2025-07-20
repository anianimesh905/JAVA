package src.Array.Easy;

import java.util.HashSet;

// 🚀 QUESTION:
// Write a Java program to perform Set Operations on two arrays:
// ➤ Union: All unique elements from both arrays.
// ➤ Intersection: Common elements between both arrays.
// ➤ Difference: Elements present in the first array but not in the second.

public class SetOperation {

    // ✅ Union Function
    static void unionEle(int[] a, int[] b){
        HashSet<Integer> e = new HashSet<>();
        for(int i : a)
            e.add(i);
        for(int i : b)
            e.add(i);

        System.out.print("Union: ");
        for (int i : e)
            System.out.print(i + " ");
        System.out.println();
    }

    // ✅ Intersection Function
    static void intersectionEle(int[] a, int[] b){
        HashSet<Integer> set = new HashSet<>();
        for (int i : a)
            set.add(i);

        HashSet<Integer> intersection = new HashSet<>();
        for (int i : b) {
            if (set.contains(i))
                intersection.add(i);
        }

        System.out.print("Intersection: ");
        for (int i : intersection)
            System.out.print(i + " ");
        System.out.println();
    }

    // ✅ Difference Function (arr1 - arr2)
    static void differenceEle(int[] a, int[] b){
        HashSet<Integer> setB = new HashSet<>();
        for (int i : b)
            setB.add(i);

        HashSet<Integer> difference = new HashSet<>();
        for (int i : a) {
            if (!setB.contains(i))
                difference.add(i);
        }

        System.out.print("Difference (arr1 - arr2): ");
        for (int i : difference)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};

        unionEle(arr1, arr2);
        intersectionEle(arr1, arr2);
        differenceEle(arr1, arr2);
    }
}
