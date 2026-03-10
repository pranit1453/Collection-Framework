package com.demo.comparator.service;

import com.demo.comparator.models.StringLengthComparator;

import java.util.Comparator;
import java.util.List;

public class ComparatorService implements IComparatorService {

    private final StringLengthComparator slc = new StringLengthComparator();

    @Override
    public void sortingLogicComparator(List<String> list) {

        /* 1. Sorting using Custom Comparator Class
           -----------------------------------------------
           Uses the StringLengthComparator which sorts
           strings based on their length in descending order.
         */
        list.sort(slc);
        System.out.println("Custom Comparator (length desc) : " + list);


        /* 2. Sorting using Lambda Expression (Descending)
           -------------------------------------------------
           Sorting based on string length in descending order
         */
        list.sort((a, b) -> b.length() - a.length());
        System.out.println("Lambda Descending : " + list);


        /* 3. Sorting using Lambda Expression (Ascending)
           -------------------------------------------------
           Sorting based on string length in ascending order
         */
        list.sort((a, b) -> a.length() - b.length());
        System.out.println("Lambda Ascending : " + list);


        /* 4. Natural Sorting
           -------------------------------------------------
           list.sort(null) uses natural ordering defined
           by Comparable interface of the object.

           For String → alphabetical order
         */
        list.sort(null);
        System.out.println("Natural Sorting : " + list);


        /* 5. Modern Comparator API (Recommended in Java 8+)
           -------------------------------------------------
         */

        // ascending length
        list.sort(Comparator.comparingInt(String::length));
        System.out.println("Comparator.comparingInt Asc : " + list);

        // descending length
        list.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println("Comparator.comparingInt Desc : " + list);


        /* 6. Multiple Level Sorting (Advanced)
           -------------------------------------------------
           First sort by length, then alphabetically
         */

        list.sort(
                Comparator.comparingInt(String::length)
                        .thenComparing(String::compareTo)
        );

        System.out.println("Multi-level sorting : " + list);
    }
}