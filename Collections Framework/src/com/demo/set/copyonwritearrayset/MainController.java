package com.demo.set.copyonwritearrayset;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ConcurrentSkipListSet;

public class MainController {

    public static void main(String[] args) {

        /*
        ---------------------------------------------------------
        1. CopyOnWriteArraySet
        ---------------------------------------------------------

        - Thread-safe Set implementation
        - Uses Copy-On-Write mechanism
        - Internally uses CopyOnWriteArrayList
        - No duplicate elements allowed
        - Iterators DO NOT reflect modifications during iteration
        */

        CopyOnWriteArraySet<Integer> copyOnWriteSet = new CopyOnWriteArraySet<>();


        /*
        ---------------------------------------------------------
        2. ConcurrentSkipListSet
        ---------------------------------------------------------

        - Thread-safe
        - Sorted Set
        - Internally uses ConcurrentSkipListMap
        - Uses Skip List data structure
        - Iterators reflect modifications
        */

        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();


        /*
        ---------------------------------------------------------
        3. Adding Elements
        ---------------------------------------------------------
        */

        for (int i = 1; i <= 5; i++) {

            copyOnWriteSet.add(i);
            concurrentSkipListSet.add(i);

        }

        System.out.println("Initial CopyOnWriteArraySet: " + copyOnWriteSet);
        System.out.println("Initial ConcurrentSkipListSet: " + concurrentSkipListSet);


        /*
        ---------------------------------------------------------
        4. Iterating CopyOnWriteArraySet
        ---------------------------------------------------------

        Iterator works on a SNAPSHOT of the collection.

        Even if we modify the set during iteration,
        the iterator does not see the new element.
        */

        System.out.println("\nIterating and modifying CopyOnWriteArraySet:");

        for (Integer num : copyOnWriteSet) {

            System.out.println("Reading: " + num);

            // modifying during iteration
            copyOnWriteSet.add(6);
        }

        System.out.println("Final CopyOnWriteArraySet: " + copyOnWriteSet);


        /*
        ---------------------------------------------------------
        5. Iterating ConcurrentSkipListSet
        ---------------------------------------------------------

        ConcurrentSkipListSet allows modifications during iteration
        and iterator can reflect changes.
        */

        System.out.println("\nIterating and modifying ConcurrentSkipListSet:");

        for (Integer num : concurrentSkipListSet) {

            System.out.println("Reading: " + num);

            concurrentSkipListSet.add(6);
        }

        System.out.println("Final ConcurrentSkipListSet: " + concurrentSkipListSet);



        /*
        ---------------------------------------------------------
        6. Multithreading Example
        ---------------------------------------------------------
        */

        Thread writerThread = new Thread(() -> {

            for (int i = 6; i <= 10; i++) {

                copyOnWriteSet.add(i);
                concurrentSkipListSet.add(i);

                System.out.println(Thread.currentThread().getName()
                        + " added " + i);

                sleep();

            }

        });


        Thread readerThread = new Thread(() -> {

            for (Integer num : copyOnWriteSet) {

                System.out.println(Thread.currentThread().getName()
                        + " reading CopyOnWriteArraySet: " + num);

                sleep();
            }

        });


        writerThread.start();
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