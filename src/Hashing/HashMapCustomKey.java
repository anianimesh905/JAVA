package src.Hashing;

import java.util.HashMap;
import java.util.Objects;

// 🔸 Custom class to be used as a key in HashMap
class Student {
    int id;
    String name;

    // 🔹 Constructor to initialize student data
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 🔁 hashCode(): Used by HashMap to find bucket index
    @Override
    public int hashCode() {
        // We are using only `id` to generate hash
        // You can also use both `id` and `name` if needed
        return Objects.hash(id);
    }

    // 🔍 equals(): Used to check if two Student objects are "equal"
    @Override
    public boolean equals(Object obj) {
        // Check if both references point to the same object
        if (this == obj) return true;

        // If obj is null or not a Student object, return false
        if (obj == null || getClass() != obj.getClass()) return false;

        // Typecast to Student to access fields
        Student other = (Student) obj;

        // Compare only `id` (you can include name if needed)
        return this.id == other.id;
    }

    // 🧾 toString(): For easy printing in console
    @Override
    public String toString() {
        return "(" + id + ", " + name + ")";
    }
}

public class HashMapCustomKey {
    public static void main(String[] args) {

        // 🔸 Creating two Student objects with same id and name
        Student s1 = new Student(101, "Alice");
        Student s2 = new Student(101, "Alice");

        // 🔸 Creating a HashMap with Student as key and String as value
        HashMap<Student, String> map = new HashMap<>();

        // ✅ Adding entry to the map using s1 as key
        map.put(s1, "Topper");

        // ✅ Now we try to get the value using s2 (which has same id and name)
        String result = map.get(s2);

        // 🔍 Print hash codes and equality check
        System.out.println("s1.hashCode() = " + s1.hashCode());
        System.out.println("s2.hashCode() = " + s2.hashCode());
        System.out.println("s1.equals(s2) = " + s1.equals(s2));

        // 🔍 If equals() and hashCode() are overridden correctly,
        // s2 should retrieve the same value as s1
        System.out.println("Retrieved using s2 → " + result);

        // 🔍 Print entire map content
        System.out.println("HashMap content: " + map);
    }
}
