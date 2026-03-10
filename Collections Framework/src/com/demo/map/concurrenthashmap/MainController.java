package com.demo.map.concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MainController {

    public static void main(String[] args) {

        /*
        ---------------------------------------------------------
        1. Creating ConcurrentHashMap
        ---------------------------------------------------------

        ConcurrentHashMap is a thread-safe implementation of Map.

        Key Properties:
        - Thread-safe
        - High performance in multithreading
        - Uses CAS (Compare And Swap)
        - No segmentation in Java 8+
        - Does NOT allow null key or null value
        */

        Map<String, Integer> map = new ConcurrentHashMap<>();


        /*
        ---------------------------------------------------------
        2. Adding Elements
        ---------------------------------------------------------
        */

        map.put("Ram", 10);
        map.put("Shyam", 20);
        map.put("Ravi", 30);

        System.out.println("Initial Map: " + map);


        /*
        ---------------------------------------------------------
        3. putIfAbsent()
        ---------------------------------------------------------
        Adds element only if key does not exist
        */

        map.putIfAbsent("Ram", 50); // will not overwrite
        map.putIfAbsent("Kiran", 40);

        System.out.println("After putIfAbsent: " + map);


        /*
        ---------------------------------------------------------
        4. get()
        ---------------------------------------------------------
        */

        System.out.println("Value of Ram: " + map.get("Ram"));


        /*
        ---------------------------------------------------------
        5. replace()
        ---------------------------------------------------------
        */

        map.replace("Ram", 100);

        System.out.println("After replace: " + map);


        /*
        ---------------------------------------------------------
        6. remove()
        ---------------------------------------------------------
        */

        map.remove("Ravi");

        System.out.println("After removing Ravi: " + map);


        /*
        ---------------------------------------------------------
        7. Iterating Map
        ---------------------------------------------------------
        */

        map.forEach((key, value) ->
                System.out.println(key + " -> " + value)
        );


        /*
        ---------------------------------------------------------
        8. computeIfAbsent()
        ---------------------------------------------------------
        */

        map.computeIfAbsent("Aman", k -> 60);

        System.out.println("After computeIfAbsent: " + map);


        /*
        ---------------------------------------------------------
        9. computeIfPresent()
        ---------------------------------------------------------
        */

        map.computeIfPresent("Ram", (k, v) -> v + 10);

        System.out.println("After computeIfPresent: " + map);


        /*
        ---------------------------------------------------------
        10. merge()
        ---------------------------------------------------------
        */

        map.merge("Shyam", 5, (oldVal, newVal) -> oldVal + newVal);

        System.out.println("After merge: " + map);


        /*
        ---------------------------------------------------------
        11. Map Information
        ---------------------------------------------------------
        */

        System.out.println("Map Size: " + map.size());
        System.out.println("Contains Key Ram: " + map.containsKey("Ram"));
        System.out.println("Contains Value 40: " + map.containsValue(40));


        /*
        ---------------------------------------------------------
        12. Multithreading Example
        ---------------------------------------------------------
        */

        Thread writerThread = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                map.put("User" + i, i * 10);

                System.out.println(
                        Thread.currentThread().getName()
                                + " added User" + i
                );

                sleep();
            }

        });


        Thread updaterThread = new Thread(() -> {

            for (int i = 0; i < 5; i++) {

                map.computeIfPresent("Ram", (k, v) -> v + 1);

                System.out.println(
                        Thread.currentThread().getName()
                                + " updated Ram value: " + map.get("Ram")
                );

                sleep();
            }

        });


        Thread readerThread = new Thread(() -> {

            for (int i = 0; i < 5; i++) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " reading map: " + map
                );

                sleep();
            }

        });


        /*
        ---------------------------------------------------------
        13. Starting Threads
        ---------------------------------------------------------
        */

        writerThread.start();
        updaterThread.start();
        readerThread.start();
    }


    /*
    Utility sleep method
     */
    static void sleep() {

        try {
            Thread.sleep(300);
        } catch (Exception ignored) {}

    }
}