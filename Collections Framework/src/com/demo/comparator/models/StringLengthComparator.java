package com.demo.comparator.models;

import java.util.Comparator;

/*
    Custom Comparator to sort Strings based on their length.

    Comparator is used when we want custom sorting logic
    instead of natural ordering.

    Here we are sorting Strings by their length.
*/

public class StringLengthComparator implements Comparator<String> {

    /*
        Comparator contract:

        return negative value  → first element comes before second
        return zero            → both elements are equal
        return positive value  → second element comes before first

        Example:
        s1 = "Java"  (length = 4)
        s2 = "SpringBoot" (length = 10)
    */

    @Override
    public int compare(String s1, String s2) {

        /*
            Descending order by length

            If s2.length() > s1.length() → positive → s2 comes first
            If s1.length() > s2.length() → negative → s1 comes first
        */

        return s2.length() - s1.length();
    }
}