/*
 * Find Itinerary from Tickets
 *
 * Given a list of flight tickets represented as pairs of source and destination cities,
 * reconstruct the full travel itinerary in the correct order.
 *
 * Input:
 *   "Chennai" -> "Bengaluru"
 *   "Mumbai"  -> "Delhi"
 *   "Goa"     -> "Chennai"
 *   "Delhi"   -> "Goa"
 *
 * Output:
 *   "Mumbai" -> "Delhi" -> "Goa" -> "Chennai" -> "Bengaluru"
 *
 * Note:
 * - The itinerary starts from the city that is never a destination.
 * - Each ticket represents a direct flight from source to destination.
 */

package src.Hashing;
import java.util.*;

public class Q4_ItineraryFinder {
    public static String getStart(HashMap<String, String> tick) {
        HashMap<String, String> revMap = new HashMap<>();

        // Build reverse map: destination -> source
        for (String key : tick.keySet()) {                    // keySet() returns a set of all keys
            revMap.put(tick.get(key), key);
        }

        // Find the starting city (not present in reverse map)
        for (String key : tick.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }

        return null; // In case no start found
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);

        // Print itinerary
        System.out.print("Itinerary: ");
        while (start != null) {
            System.out.print("\"" + start + "\"");
            if (tickets.containsKey(start)) {
                System.out.print(" -> ");
            }
            start = tickets.get(start);
        }
    }
}