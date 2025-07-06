package src.Hashing;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {
    public static void main(String[] args) {
        // country(key)   population(value)
        HashMap <String, Integer> map = new HashMap<>();

        // Insertion
        map.put("India", 140);
        map.put("USA", 40);
        map.put("China", 110);

        System.out.println(map);

        // Update if key is same else simply add
        map.put("China", 180);

        // Searching
        System.out.println(map.containsKey("USA"));
        System.out.println(map.containsValue(180));

        // getting value
        System.out.println(map.get("Indonesia"));
        System.out.println(map.get("India"));

        for (Map.Entry<String, Integer> e : map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            System.out.println(e.getClass());
        }

        map.remove("China");
        System.out.println(map);
    }
}
