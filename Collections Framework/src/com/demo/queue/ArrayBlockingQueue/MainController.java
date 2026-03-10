package com.demo.queue.ArrayBlockingQueue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MainController {

    public static void main(String[] args) throws InterruptedException {

        /*
        ---------------------------------------------------------
        1. Creating ArrayBlockingQueue
        ---------------------------------------------------------

        ArrayBlockingQueue is a bounded blocking queue.

        Characteristics:
        - Fixed capacity
        - Thread-safe
        - Uses FIFO (First In First Out)
        - Internally backed by an array
        */

        Queue<Integer> queue1 = new ArrayBlockingQueue<>(2);


        /*
        ---------------------------------------------------------
        2. Adding Elements
        ---------------------------------------------------------
        */

        queue1.add(1);     // throws exception if queue is full
        queue1.offer(2);   // returns false if queue is full

        // queue1.add(3);  // would throw IllegalStateException

        boolean added = queue1.offer(4); // returns false because queue full

        System.out.println("Queue: " + queue1);
        System.out.println("Was 4 added? " + added);


        /*
        ---------------------------------------------------------
        3. Access Elements
        ---------------------------------------------------------
        */

        System.out.println("Peek element: " + queue1.peek()); // head element


        /*
        ---------------------------------------------------------
        4. Removing Elements
        ---------------------------------------------------------
        */

        System.out.println("Removed using poll(): " + queue1.poll());

        System.out.println("Queue after poll: " + queue1);


        /*
        ---------------------------------------------------------
        5. Queue information
        ---------------------------------------------------------
        */

        System.out.println("Queue size: " + queue1.size());
        System.out.println("Is queue empty: " + queue1.isEmpty());


        /*
        ---------------------------------------------------------
        6. Multithreading Example
        Producer – Consumer
        ---------------------------------------------------------
        */

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);


        /*
        Producer Thread
        Adds elements to queue
        */
        Thread producer = new Thread(() -> {

            for (int i = 1; i <= 10; i++) {

                try {

                    System.out.println("Producing: " + i);

                    queue.put(i); // waits if queue is full

                    Thread.sleep(500);

                } catch (Exception e) {
                    System.out.println("Producer Exception : "+e.getMessage());
                }
            }

        });


        /*
        Consumer Thread
        Removes elements from queue
        */
        Thread consumer = new Thread(() -> {

            for (int i = 1; i <= 10; i++) {

                try {

                    Integer value = queue.take(); // waits if queue empty

                    System.out.println("Consumed: " + value);

                    Thread.sleep(800);

                } catch (Exception e) {
                    System.out.println("Consumer Exception : "+e.getMessage());
                }
            }

        });


        producer.start();
        consumer.start();
    }
}