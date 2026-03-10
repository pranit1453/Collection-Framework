package com.demo.list.linkedlist;



import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainController {

    static void main() {


       // 1. Creating LinkedList

        List<Integer> l_list = new LinkedList<>();


        // 2. Adding Elements

        // add() → adds element at the end
        l_list.add(1);
        l_list.add(2);
        l_list.add(3);
        l_list.add(4);

        // addFirst() → insert element at beginning
        l_list.addFirst(10);

        // addLast() → insert element at end
        l_list.addLast(100);

        // add(index, element) → insert at specific position
        l_list.add(3, 40);


       // 3. Accessing Elements

        // get(index) → access element at given index
        l_list.get(1);

        // getFirst() → first element
        l_list.getFirst();

        // getLast() → last element
        l_list.getLast();


        // 4. Updating Elements

        // set(index, element) → replace element at index
        l_list.set(2, 50);


        // 5. Removing Elements


        // remove(index) → remove element at specific index
        l_list.remove(1);

        // removeFirst()
        l_list.removeFirst();

        // removeLast()
        l_list.removeLast();

        // remove(Object)
        l_list.remove(Integer.valueOf(3));


       // 6. Searching Operations

        // contains() → checks if element exists
        boolean contains = l_list.contains(40);

        // indexOf() → first occurrence
        int index = l_list.indexOf(40);

        // lastIndexOf() → last occurrence
        int lastIndex = l_list.lastIndexOf(40);



        // 8. Iteration Methods

        // using forEach
        l_list.forEach(System.out::println);

        // using iterator
        Iterator<Integer> iterator = l_list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // enhanced for loop

        for (Integer integer : l_list) {
            System.out.println(integer);
        }


        // 9. Size & State

        int size = l_list.size();
        boolean isEmpty = l_list.isEmpty();


        // 10. Clearing List

        // remove all elements
        // l_list.clear();


        /* -------------------------------------------------
           11. Important Internal Characteristics
           -------------------------------------------------

           LinkedList is implemented as a
           Doubly Linked List.

           Each node contains:
           1. Data
           2. Reference to next node
           3. Reference to previous node

           Time Complexity:

           Access by index       → O(n)
           Insert at beginning   → O(1)
           Insert at end         → O(1)
           Insert in middle      → O(n)
           Remove element        → O(1) if node known
           Searching             → O(n)

         */
    }
}