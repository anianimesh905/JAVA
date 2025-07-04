package src.Fundamental;

public class StringRecap {
    public static void main(String[] args) {
        // Create Strings
        String s1 = "Hello";
        String s2 = "World";
        String s3 = "Hello";

        // Length
        System.out.println("Length: " + s1.length());

        // Concatenation
        String concat = s1 + " " + s2;
        System.out.println("Concatenation: " + concat);
        System.out.println("Using concat(): " + s1.concat(s2));

        // Comparison
        System.out.println("Equals: " + s1.equals(s3));           // true
        System.out.println("EqualsIgnoreCase: " + s1.equalsIgnoreCase("hello")); // true
        System.out.println("CompareTo: " + s1.compareTo(s2));     // Lexicographical

        // Character Access
        System.out.println("Char at index 1: " + s1.charAt(1));   // 'e'

        // Substring
        System.out.println("Substring (0, 3): " + s1.substring(0, 3)); // "Hel"

        // Contains
        System.out.println("Contains 'lo': " + s1.contains("lo"));    // true

        // Index of
        System.out.println("Index of 'l': " + s1.indexOf('l'));       // 2
        System.out.println("Last index of 'l': " + s1.lastIndexOf('l')); // 3

        // Replace
        System.out.println("Replace 'l' with 'x': " + s1.replace('l', 'x'));

        // Trim
        String spaced = "   Hello World   ";
        System.out.println("Trimmed: '" + spaced.trim() + "'");

        // Case conversion
        System.out.println("To Upper: " + s1.toUpperCase());
        System.out.println("To Lower: " + s2.toLowerCase());

        // Split
        String sentence = "Java is fun";
        String[] words = sentence.split(" ");
        System.out.println("Split words:");
        for(String word : words) {
            System.out.println(word);
        }

        // StartsWith & EndsWith
        System.out.println("Starts with 'He': " + s1.startsWith("He"));
        System.out.println("Ends with 'lo': " + s1.endsWith("lo"));

        // isEmpty & isBlank
        String empty = "";
        String blank = "   ";
        System.out.println("Is empty: " + empty.isEmpty());
        System.out.println("Is blank: " + blank.isBlank());  // Java 11+

        // Interning
        System.out.println("s1 == s3: " + (s1 == s3));       // true (interned)
        System.out.println("s1 == new String(): " + (s1 == new String("Hello"))); // false

        // Using Character.isLetterOrDigit()
        char ch1 = 'A';
        char ch2 = '!';
        System.out.println("Is 'A' a letter or digit? " + Character.isLetterOrDigit(ch1)); // true
        System.out.println("Is '!' a letter or digit? " + Character.isLetterOrDigit(ch2)); // false

        // StringBuilder (for efficient editing)
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(0, "Say ");
        sb.delete(4, 8);
        sb.reverse();
        System.out.println("StringBuilder result: " + sb.toString());
    }
}

