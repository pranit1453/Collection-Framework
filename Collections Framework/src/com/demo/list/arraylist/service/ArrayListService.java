package com.demo.list.arraylist.service;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListService implements IArrayListService {

    @Override
    public void methodsOfArrayList(ArrayList<Integer> list) {

        // 1. ADDING ELEMENTS

        // add(E e) → adds element at the end
        list.add(8);
        list.add(5);

        // adding elements using loop
        for (int i = 2; i < 10; i++) {
            int data = 10 + i;
            list.add(data);
        }

        // add(index, element) → insert element at specific index
        list.add(2, 100);

        // set(index, element) → replaces element at given index
        list.set(2, 50);


        // 2. PRINTING USING STREAM API

        // convert list to formatted string like [1, 2, 3]
        String data = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(data);


        // 3. CLASS INFORMATION

        // runtime class of ArrayList
        System.out.println("List class : " + list.getClass().getName());


        // 4. ARRAYS TO LIST

        // Arrays.asList() → creates a fixed-size list backed by array
        // You can modify elements but cannot add/remove
        List<String> array_to_list = Arrays.asList("Akash", "Ravi", "Ram");
        System.out.println(array_to_list.getClass().getName());


        // List.of() → immutable list (Java 9+)
        // Cannot add, remove, or modify elements
        List<Integer> list_with_list = List.of(1, 2, 3);


        // 5. REMOVING ELEMENTS

        // remove(Object o) → removes first occurrence of value
        list.remove(Integer.valueOf(1));

        // remove(index) → removes element at index
        if(list.size() > 2) {
            list.remove(2);
        }


        // 6. SEARCHING

        // contains() → checks if element exists
        boolean contains = list.contains(8);

        // indexOf() → returns first occurrence index
        int index = list.indexOf(8);

        // lastIndexOf() → returns last occurrence index
        int lastIndex = list.lastIndexOf(8);


        // 7. SIZE AND EMPTY CHECK

        int size = list.size();       // number of elements
        boolean empty = list.isEmpty();


        // 8. ITERATION METHODS

        // using forEach
        list.forEach(x -> System.out.print(x + " "));
        System.out.println();

        // using iterator
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // using enhanced for loop
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();


        // 9. CONVERTING LIST TO ARRAY

        Integer[] array = list.toArray(new Integer[0]);

        // 10. SORTING

        // natural sorting (ascending)
        Collections.sort(list);

        // same as above
        list.sort(null);

        // custom sorting (descending)
        list.sort(Comparator.reverseOrder());


        // 11. SUBLIST

        // creates a view of portion of list
        if(list.size() >= 3) {
            List<Integer> subList = list.subList(0, 3);
        }



        //  12. CLEAR LIST

        // removes all elements
        // list.clear();

        // 13. CAPACITY METHODS

        // ensures internal capacity
        list.ensureCapacity(50);

        // trims unused capacity
        list.trimToSize();


        /* -------------------------------------------------
           14. TIME COMPLEXITY
           -------------------------------------------------

           Access by index        → O(1)
           Adding element         → O(1) average
           Adding (resize case)   → O(n)
           Removing element       → O(n) (shifting required)
           Searching element      → O(n)
           Iteration              → O(n)

         */
    }
}