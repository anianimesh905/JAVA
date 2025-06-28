// We will declare various variables and print there range and sizes.

package src.Fundamental;

public class varDecl 
{
    public static void main(String[] args) 
    {
        byte byteVar = 0;
        short shortVar = 0;
        int intVar = 0;
        long longVar = 0L;
        float floatVar = 0.0f;
        double doubleVar = 0.0;
        char charVar = '\u0000'; // basically means Null
        boolean booleanVar = false;
        
        // Display the variables and their default values
        System.out.println("Variable Type | Default Value | Size (bits)");
        System.out.println("============================================");
        System.out.println("byte         | " + byteVar + "             | 8");
        System.out.println("short        | " + shortVar + "             | 16");
        System.out.println("int          | " + intVar + "             | 32");
        System.out.println("long         | " + longVar + "L            | 64");
        System.out.println("float        | " + floatVar + "f           | 32");
        System.out.println("double       | " + doubleVar + "           | 64");
        System.out.println("char         | '" + charVar + "' (null)    | 16");
        System.out.println("boolean      | " + booleanVar + "         | 1 (JVM dependent)");
        
        // Additional information about ranges
        System.out.println("\n=== Value Ranges ===");
        System.out.println("byte range   : " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("short range  : " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("int range    : " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("long range   : " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);
        System.out.println("float range  : " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
        System.out.println("double range : " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
        System.out.println("char range   : " + (int)Character.MIN_VALUE + " to " + (int)Character.MAX_VALUE);

    }
}
