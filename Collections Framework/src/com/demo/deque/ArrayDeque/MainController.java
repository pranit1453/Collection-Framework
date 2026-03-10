package com.demo.deque.ArrayDeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MainController {

    public static void main(String[] args) {

        /*
        ---------------------------------------------------------
        Deque (Double Ended Queue)
        ---------------------------------------------------------

        Allows insertion and removal from BOTH ends.

        Works as:
        - Queue (FIFO)
        - Stack (LIFO)

        ArrayDeque is preferred over Stack and LinkedList
        for most cases because it is faster and uses less memory.
        */

        /*
        ---------------------------------------------------------
        Creating ArrayDeque
        ---------------------------------------------------------
        */

        Deque<Integer> deque1 = new ArrayDeque<>();


        /*
        ---------------------------------------------------------
        INSERTION METHODS
        ---------------------------------------------------------
        */

        deque1.addFirst(10);   // insert at front
        deque1.addLast(20);    // insert at end

        deque1.offerFirst(5);  // safe insert at front
        deque1.offerLast(25);  // safe insert at end

        /*
        Current Deque
        */

        System.out.println("Deque after insertion: " + deque1);


        /*
        ---------------------------------------------------------
        EXAMINATION METHODS
        ---------------------------------------------------------
        */

        System.out.println("First Element: " + deque1.getFirst());
        System.out.println("Last Element: " + deque1.getLast());

        System.out.println("Peek First: " + deque1.peekFirst());
        System.out.println("Peek Last: " + deque1.peekLast());


        /*
        ---------------------------------------------------------
        REMOVAL METHODS
        ---------------------------------------------------------
        */

        deque1.removeFirst(); // removes first element
        deque1.pollLast();    // removes last element safely

        System.out.println("Deque after removals: " + deque1);


        /*
        ---------------------------------------------------------
        ITERATION
        ---------------------------------------------------------
        */

        System.out.println("Iterating deque:");

        for (int num : deque1) {

            System.out.println(num);

        }


        /*
        ---------------------------------------------------------
        STACK OPERATIONS
        ---------------------------------------------------------

        ArrayDeque can act as a Stack.
        */

        deque1.push(50);  // same as addFirst()
        deque1.push(60);

        System.out.println("After push operations: " + deque1);

        int popped = deque1.pop(); // removes first element

        System.out.println("Popped element: " + popped);

        System.out.println("Deque after pop: " + deque1);


        /*
        ---------------------------------------------------------
        LinkedList as Deque
        ---------------------------------------------------------
        */

        Deque<Integer> deque2 = new LinkedList<>();

        deque2.addFirst(1);
        deque2.addLast(2);
        deque2.addLast(3);

        System.out.println("LinkedList Deque: " + deque2);


        /*
        ---------------------------------------------------------
        Important Notes
        ---------------------------------------------------------

        1. ArrayDeque does NOT allow null elements
        2. Faster than LinkedList for most operations
        3. Uses circular array internally
        4. Head and tail pointers move instead of shifting elements
        */
    }
}