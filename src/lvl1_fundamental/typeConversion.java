package src.lvl1_fundamental;
public class typeConversion {
    public static void main(String[] args) {
        System.out.println("=== Type Conversion in Java ===");
        
        // ===== IMPLICIT TYPE CONVERSION (WIDENING) =====
        System.out.println("\n1. IMPLICIT TYPE CONVERSION (Widening/Automatic)");
        System.out.println("Smaller data type -> Larger data type");
        System.out.println("No data loss occurs");
        System.out.println("Order: byte -> short -> int -> long -> float -> double");
        System.out.println("       char -> int");
        
        byte originalByte = 120;
        short shortFromByte = originalByte;    // byte to short
        int intFromShort = shortFromByte;      // short to int
        long longFromInt = intFromShort;       // int to long
        float floatFromLong = longFromInt;     // long to float
        double doubleFromFloat = floatFromLong; // float to double
        
        System.out.println("\nWidening Conversion Chain:");
        System.out.println("byte: " + originalByte + " -> short: " + shortFromByte);
        System.out.println("short: " + shortFromByte + " -> int: " + intFromShort);
        System.out.println("int: " + intFromShort + " -> long: " + longFromInt);
        System.out.println("long: " + longFromInt + " -> float: " + floatFromLong);
        System.out.println("float: " + floatFromLong + " -> double: " + doubleFromFloat);
        
        // Character to int conversion
        char ch = 'A';
        int intFromChar = ch;
        System.out.println("\nChar to int: '" + ch + "' -> " + intFromChar + " (ASCII value)");
        
        // ===== EXPLICIT TYPE CONVERSION (NARROWING) =====
        System.out.println("\n2. EXPLICIT TYPE CONVERSION (Narrowing/Manual Casting)");
        System.out.println("Larger data type -> Smaller data type");
        System.out.println("May cause data loss - requires explicit casting");
        
        double originalDouble = 123.789;
        float floatFromDouble = (float) originalDouble;
        long longFromDouble = (long) originalDouble;
        int intFromDouble = (int) originalDouble;
        short shortFromInt = (short) intFromDouble;
        byte byteFromShort = (byte) shortFromInt;
        
        System.out.println("\nNarrowing Conversion Chain:");
        System.out.println("double: " + originalDouble + " -> float: " + floatFromDouble);
        System.out.println("double: " + originalDouble + " -> long: " + longFromDouble + " (decimal part lost)");
        System.out.println("double: " + originalDouble + " -> int: " + intFromDouble + " (decimal part lost)");
        System.out.println("int: " + intFromDouble + " -> short: " + shortFromInt);
        System.out.println("short: " + shortFromInt + " -> byte: " + byteFromShort);
        
        // Demonstrating data loss
        System.out.println("\n=== Data Loss Examples ===");
        
        int largeInt = 300;
        byte smallByte = (byte) largeInt;
        System.out.println("int " + largeInt + " -> byte " + smallByte + " (Data loss: " + (largeInt - smallByte) + ")");
        
        double preciseDouble = 99.99;
        int truncatedInt = (int) preciseDouble;
        System.out.println("double " + preciseDouble + " -> int " + truncatedInt + " (Decimal part lost)");
        
        // String to numeric conversion (using wrapper classes)
        System.out.println("\n=== String to Numeric Conversion ===");
        String numberString = "456";
        int parsedInt = Integer.parseInt(numberString);
        double parsedDouble = Double.parseDouble(numberString);
        
        System.out.println("String \"" + numberString + "\" -> int: " + parsedInt);
        System.out.println("String \"" + numberString + "\" -> double: " + parsedDouble);
        
        // Numeric to String conversion
        int number = 789;
        String numberToString = String.valueOf(number);
        String numberToString2 = Integer.toString(number);
        
        System.out.println("int " + number + " -> String: \"" + numberToString + "\"");
        System.out.println("int " + number + " -> String (alternative): \"" + numberToString2 + "\"");
    }
}
