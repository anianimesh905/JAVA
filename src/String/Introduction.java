package src.String;

/**
 * String Introduction & Cheat Sheet
 * This class demonstrates almost all major String operations in Java.
 * Each section shows the method usage with example output and comments.
 */
public class Introduction {
    public static void main(String[] args) {

        // -------------------------------
        // 1. Creation of Strings
        // -------------------------------
        String str1 = "Hello";                     // String literal
        String str2 = new String("World");         // Using 'new' keyword
        String str3 = "Hello";                     // Points to same object as str1 in string pool

        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str1 == str3? " + (str1 == str3)); // true (same pool reference)
        System.out.println("str1 == str2? " + (str1 == str2)); // false (different object)
        System.out.println();

        // -------------------------------
        // 2. Basic Information Methods
        // -------------------------------
        System.out.println("Length of str1: " + str1.length());    // length()
        System.out.println("Character at index 1: " + str1.charAt(1)); // charAt()
        System.out.println("Is str1 empty? " + str1.isEmpty());    // isEmpty()
        System.out.println();

        // -------------------------------
        // 3. String Comparison
        // -------------------------------
        String a = "Java";
        String b = "java";

        System.out.println("equals(): " + a.equals(b));                // false
        System.out.println("equalsIgnoreCase(): " + a.equalsIgnoreCase(b)); // true
        System.out.println("compareTo(): " + a.compareTo(b));          // negative if a < b
        System.out.println("compareToIgnoreCase(): " + a.compareToIgnoreCase(b)); // 0 if equal ignoring case
        System.out.println();

        // -------------------------------
        // 4. Searching
        // -------------------------------
        String text = "Java Programming Language";
        System.out.println("indexOf('P'): " + text.indexOf('P'));         // indexOf()
        System.out.println("lastIndexOf('a'): " + text.lastIndexOf('a')); // lastIndexOf()
        System.out.println("contains(\"gram\"): " + text.contains("gram")); // contains()
        System.out.println("startsWith(\"Java\"): " + text.startsWith("Java")); // startsWith()
        System.out.println("endsWith(\"Language\"): " + text.endsWith("Language")); // endsWith()
        System.out.println();

        // -------------------------------
        // 5. Case Conversion & Trimming
        // -------------------------------
        String mixed = "   JaVa Is FUN   ";
        System.out.println("toUpperCase(): " + mixed.toUpperCase());
        System.out.println("toLowerCase(): " + mixed.toLowerCase());
        System.out.println("trim(): '" + mixed.trim() + "'"); // removes spaces at start/end
        System.out.println();

        // -------------------------------
        // 6. Substring & Concatenation
        // -------------------------------
        String s = "HelloWorld";
        System.out.println("substring(0,5): " + s.substring(0, 5)); // "Hello"
        System.out.println("concat(): " + s.concat("Java"));         // HelloWorldJava
        System.out.println("Using + operator: " + s + "Java");       // HelloWorldJava
        System.out.println();

        // -------------------------------
        // 7. Replacement
        // -------------------------------
        String replaced = text.replace("Java", "Python");   // replaces all matches
        String replacedChar = text.replace('a', 'o');       // replaces all characters
        String replaceFirst = text.replaceFirst("a", "A");  // replaces first occurrence

        System.out.println("replace(): " + replaced);
        System.out.println("replace(char,char): " + replacedChar);
        System.out.println("replaceFirst(): " + replaceFirst);
        System.out.println();

        // -------------------------------
        // 8. Splitting & Joining
        // -------------------------------
        String csv = "apple,banana,orange";
        String[] fruits = csv.split(","); // split by comma

        System.out.print("split(): ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        String joined = String.join(" - ", fruits); // join with separator
        System.out.println("join(): " + joined);
        System.out.println();

        // -------------------------------
        // 9. StringBuilder (Mutable String)
        // -------------------------------
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");               // append
        sb.insert(5, ",");                  // insert
        sb.replace(0, 5, "Hi");             // replace
        sb.delete(2, 3);                    // delete
        sb.reverse();                       // reverse string
        System.out.println("StringBuilder result: " + sb);
        System.out.println();

        // -------------------------------
        // 10. StringBuffer (Thread-safe)
        // -------------------------------
        StringBuffer sbf = new StringBuffer("Safe");
        sbf.append(" Buffer");
        System.out.println("StringBuffer result: " + sbf);
        System.out.println();

        // -------------------------------
        // 11. Formatting
        // -------------------------------
        String name = "Animesh";
        int age = 22;
        double score = 95.5678;

        String formatted = String.format("Name: %s, Age: %d, Score: %.2f", name, age, score);
        System.out.println("Formatted String: " + formatted);
    }
}
