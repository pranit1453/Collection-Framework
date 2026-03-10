package com.demo.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainController {

    public static void main(String[] args) {

        /* -------------------------------------------------
           1. Creating HashMap
           -------------------------------------------------

           - Stores key-value pairs
           - Only ONE null key allowed
           - Multiple null values allowed
           - Order is NOT maintained
        */

        Map<Integer, String> map = new HashMap<>();


        /* -------------------------------------------------
           2. Adding Elements
           ------------------------------------------------- */

        // put(key, value) → adds or updates value
        map.put(1, "Ram");
        map.put(4, "Kiran");
        map.put(2, "Ram");
        map.put(10, "Ravi");

        System.out.println("Initial Map : " + map);


        /* -------------------------------------------------
           3. Iterating using forEach (Lambda)
           ------------------------------------------------- */

        map.forEach((key, value) ->
                System.out.println(key + " ---> " + value));


        /* -------------------------------------------------
           4. Accessing Elements
           ------------------------------------------------- */

        // get(key) → returns value
        String student = map.get(4);
        System.out.println("Value of key 4 : " + student);

        // getOrDefault(key, defaultValue)
        String value = map.getOrDefault(100, "Not Found");
        System.out.println("GetOrDefault : " + value);


        /* -------------------------------------------------
           5. Checking Existence
           ------------------------------------------------- */

        // containsKey()
        boolean hasKey = map.containsKey(1);

        // containsValue()
        boolean hasValue = map.containsValue("Ram");

        System.out.println("Contains key 1 : " + hasKey);
        System.out.println("Contains value Ram : " + hasValue);


        /* -------------------------------------------------
           6. Iterating using keySet()
           -------------------------------------------------

           Returns Set of keys
        */

        Set<Integer> keys = map.keySet();

        for (int key : keys)
            System.out.println("KeySet → " + key + " : " + map.get(key));


        /* -------------------------------------------------
           7. Iterating using entrySet() (Best Performance)
           -------------------------------------------------

           Provides both key and value directly
        */

        for (Map.Entry<Integer, String> entry : map.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());


        /* -------------------------------------------------
           8. Removing Elements
           ------------------------------------------------- */

        // remove(key)
        map.remove(10);

        // remove(key,value)
        map.remove(2, "Ram");


        /* -------------------------------------------------
           9. Updating Elements
           ------------------------------------------------- */

        // replace(key,value)
        map.replace(1, "Shyam");

        // replace(key,oldValue,newValue)
        map.replace(4, "Kiran", "Rohan");


        /* -------------------------------------------------
           10. Put If Absent
           -------------------------------------------------

           Adds element only if key not present
        */

        map.putIfAbsent(5, "Aman");


        /* -------------------------------------------------
           11. Size and State
           ------------------------------------------------- */

        int size = map.size();
        boolean empty = map.isEmpty();

        System.out.println("Map size : " + size);
        System.out.println("Is map empty : " + empty);


        /* -------------------------------------------------
           12. Getting Collections
           ------------------------------------------------- */

        // keySet() → returns all keys
        System.out.println("Keys : " + map.keySet());

        // values() → returns all values
        System.out.println("Values : " + map.values());

        // entrySet() → returns key-value pairs
        System.out.println("Entries : " + map.entrySet());


        /* -------------------------------------------------
           13. Compute Methods (Java 8+)
           ------------------------------------------------- */

        // computeIfAbsent
        map.computeIfAbsent(6, k -> "GeneratedValue");

        // computeIfPresent
        map.computeIfPresent(1, (k, v) -> v + "_Updated");

        // compute
        map.compute(2, (k, v) -> (v == null) ? "NewValue" : v + "_Modified");


        /* -------------------------------------------------
           14. Merge Method
           ------------------------------------------------- */

        map.merge(7, "First", (oldValue, newValue) -> oldValue + newValue);


        /* -------------------------------------------------
           15. Clearing Map
           ------------------------------------------------- */

        // map.clear();


        /* -------------------------------------------------
           16. Time Complexity
           -------------------------------------------------

           get()        → O(1)
           put()        → O(1)
           remove()     → O(1)

           Worst Case (hash collision):
           O(n)

         */


        /* -------------------------------------------------
           17. Internal Working (Java 8+)
           -------------------------------------------------

           HashMap internally uses:

           1. Get Hashcode
           2. Get index = hashcode % array size(by default 16)
           3. store in bucket

           if bucket size crosses threshold (8) then linked list converted to Red Black Tree (self balanced binary search tree)

           Array + LinkedList + Red-Black Tree

           Bucket Structure:

           index → Node → Node → Node

           If bucket size > 8 (threshold)
           it converts LinkedList → RedBlackTree

         */

        System.out.println("Final Map : " + map);
    }
}