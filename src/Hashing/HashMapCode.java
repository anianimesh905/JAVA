package src.Hashing;
import java.util.*;

public class HashMapCode {
    static class HashMap<K,V>{     // Custom generic HashMap class
        private class Node{        // Node class to hold key-value pairs
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n nodes
        private int N; // N Buckets
        private LinkedList<Node> buckets[];

        // We can't create generic arrays directly in Java (LinkedList<Node>[]),
        // so we use a normal LinkedList[] and suppress the warning using this annotation
        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4]; // buckets = [null, null, null, null]
            for (int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>(); // buckets = [LinkedList<Node, ...]
            }
        }

        private int hashFunction (K key){
            int bi = key.hashCode();   // Convert key to int
            return Math.abs(bi) % N;   // Ensure index between 0 and N-1, abs() makes the number +ive
        }

        // searchInLL: Search for the key inside the LinkedList at bucket index 'bi'
        // - If found, return the index within the LinkedList
        // - If not found, return -1
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];      // Get the linked list (bucket)
            for (int i = 0; i < ll.size(); i++) {   // Use .equals() to compare key properly (== only compares references)
                if (ll.get(i).key.equals(key)) {
                    return i;                       // Key found at index i
                }
            }
            return -1;                              // Key not found
        }

        // Rehash: Doubles the bucket size and re-inserts all key-value pairs
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;           // Save old buckets
            buckets = new LinkedList[N * 2];                  // Create new bucket array (double size)

            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();              // Initialize each new bucket
            }

            N = N * 2;                                         // Update N to new size

            // Reinsert old data into new buckets using new hash values
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);                // Use put() to rehash and insert
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);         // Get bucket index
            int di = searchInLL(key, bi);       // Get data index in LinkedList

            if (di == -1) {                     // Key not found → insert new
                buckets[bi].add(new Node(key, value));
                n++;
            } else {                            // Key found → update value
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (double) n / N;     // Load factor

            if (lambda > 2.0) {                 // Too many entries → rehash
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;                    // True if key found, else false
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) return null;          // Key not found

            Node node = buckets[bi].remove(di); // Remove and return value
            n--;
            return node.value;
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) return null;          // Key not found

            return buckets[bi].get(di).value;   // Return value
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);         // Collect all keys
                }
            }

            return keys;
        }


    }

    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);
        ArrayList<String> keys = map.keySet();
        for(int i=0; i<keys.size(); i++) {
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }

        map.remove("India");
        System.out.println(map.get("India"));
    }
}
