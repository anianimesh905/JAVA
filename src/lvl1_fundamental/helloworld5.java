package src.lvl1_fundamental;

public class helloworld5 
{
    public static void main(String[] args) 
    {
        System.out.println("=== Hello world in 5 different ways");

        System.out.println("1. Using println():");
        System.out.println("Hello, World!");
        
        System.out.println("\n2. Using print() with \\n:");
        System.out.print("Hello, World!\n");
        
        System.out.println("\n3. Using printf():");
        System.out.printf("Hello, World!%n");
        
        System.out.println("\n4. Using String.format():");
        System.out.println(String.format("Hello, World!"));
        
        System.out.println("\n5. Using variable:");
        String greeting = "Hello, World!";
        System.out.println(greeting);

    }
}
