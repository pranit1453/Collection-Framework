package com.demo.list.copyOnWriteArrayList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainController {

    public static void main(String[] args) {

        /* -------------------------------------------------
           1. What is CopyOnWriteArrayList?
           -------------------------------------------------

           "Copy On Write" means whenever a modification happens
           (add / remove / update), instead of modifying the
           existing list directly, a NEW COPY of the list is created.

           Then the modification is applied to that new copy.
           Read Operations: Fast and direct, since they happen on a stable list without interference from modifications.
           Write Operations: A new copy of the list is created for every modification.
                             The reference to the list is then updated so that subsequent reads use this new list.

           This ensures:
           - Readers are never blocked
           - Iteration is safe during modification

        */

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();


        /* -------------------------------------------------
           2. Example: Safe modification during iteration
           ------------------------------------------------- */

        List<String> shoppingList = new CopyOnWriteArrayList<>();

        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");

        System.out.println("Initial Shopping List: " + shoppingList);

        /*
           Normally this would throw:
           ConcurrentModificationException

           But CopyOnWriteArrayList allows modification
           during iteration because iteration happens on
           a snapshot copy.
        */

        for (String item : shoppingList) {
            System.out.println(item);

            if (item.equals("Eggs")) {
                shoppingList.add("Butter");
                System.out.println("Added Butter after Eggs");
            }
        }

        System.out.println("Updated Shopping List: " + shoppingList);


        /* -------------------------------------------------
           3. Multi-threaded Example
           -------------------------------------------------

           One thread reads the list continuously.
           Another thread modifies the list.

           With normal ArrayList this causes
           ConcurrentModificationException.
        */

        List<String> sharedList = new CopyOnWriteArrayList<>();

        sharedList.add("Item1");
        sharedList.add("Item2");
        sharedList.add("Item3");


        /* ---------------- Reader Thread ---------------- */

        Thread readerThread = new Thread(() -> {
            try {

                while (true) {

                    for (String item : sharedList) {
                        System.out.println("Reading Shared List : " + item);
                        Thread.sleep(100);
                    }

                }

            } catch (Exception e) {
                System.out.println("Exception in Reader Thread : " + e.getMessage());
            }
        });


        /* ---------------- Writer Thread ---------------- */

        Thread writerThread = new Thread(() -> {

            try {

                Thread.sleep(500);

                sharedList.add("Item4");
                System.out.println("Added Item4 to shared list");

                Thread.sleep(500);

                sharedList.remove("Item1");
                System.out.println("Removed Item1 from shared list");

            } catch (InterruptedException e) {

                System.out.println("Exception in Writer Thread : " + e.getMessage());
            }

        });


        /* -------------------------------------------------
           4. Start Threads
           ------------------------------------------------- */

        readerThread.start();
        writerThread.start();


        /* -------------------------------------------------
           5. Important Characteristics
           -------------------------------------------------

           Read operations  → Very fast
           Write operations → Expensive (copy happens)

           Memory usage → Higher (because copies created)

           Best used when:
           Reads >> Writes

         */


        /* -------------------------------------------------
           6. Time Complexity
           -------------------------------------------------

           get()     → O(1)
           add()     → O(n) (copy created)
           remove()  → O(n)
           iteration → O(n)

         */
    }
}