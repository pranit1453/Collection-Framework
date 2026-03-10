package com.demo.queue.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MainController {

    public static void main(String[] args) {

        /*
        ---------------------------------------------------------
        1. Default PriorityQueue
        ---------------------------------------------------------

        - Implements Queue interface
        - Uses Min Heap internally
        - Smallest element has highest priority
        - Not thread-safe
        */

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(30);
        pq.add(10);
        pq.add(20);
        pq.add(5);

        System.out.println("PriorityQueue (Min Heap): " + pq);

        /*
        peek() → retrieves head element without removing
        */

        System.out.println("Peek: " + pq.peek());


        /*
        poll() → removes head element
        */

        System.out.println("Removed: " + pq.poll());

        System.out.println("Queue after poll: " + pq);


        /*
        ---------------------------------------------------------
        2. Iterating PriorityQueue
        ---------------------------------------------------------
        */

        System.out.println("\nIterating elements:");

        pq.forEach(System.out::println);


        /*
        ---------------------------------------------------------
        3. Custom Comparator (Max Heap)
        ---------------------------------------------------------

        We can reverse ordering using comparator.
        */

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);

        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(5);

        System.out.println("\nMax Heap PriorityQueue: " + maxHeap);

        System.out.println("Max Element: " + maxHeap.peek());


        /*
        ---------------------------------------------------------
        4. Comparator using Comparator Interface
        ---------------------------------------------------------
        */

        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {

                return b - a; // descending order

            }
        };

        PriorityQueue<Integer> pqComparator =
                new PriorityQueue<>(comparator);

        pqComparator.add(15);
        pqComparator.add(50);
        pqComparator.add(25);
        pqComparator.add(5);

        System.out.println("\nPriorityQueue using Comparator: "
                + pqComparator);


        /*
        ---------------------------------------------------------
        5. Removing all elements based on priority
        ---------------------------------------------------------

        Poll always returns highest priority element.
        */

        System.out.println("\nPolling elements:");

        while (!pqComparator.isEmpty()) {

            System.out.println(pqComparator.poll());

        }


        /*
        ---------------------------------------------------------
        6. Queue information
        ---------------------------------------------------------
        */

        System.out.println("\nSize: " + pq.size());
        System.out.println("Is Empty: " + pq.isEmpty());
        System.out.println("Contains 20: " + pq.contains(20));
    }
}