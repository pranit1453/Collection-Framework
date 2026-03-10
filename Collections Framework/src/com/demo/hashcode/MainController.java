package com.demo.hashcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
    Custom class used as a key in HashMap.

    When using a custom object as a key in HashMap,
    it is VERY IMPORTANT to override:

    1. equals()
    2. hashCode()

    Otherwise HashMap cannot correctly identify duplicate keys.
*/

class Person {

    private String name;
    private int id;

    // Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getter & Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // String representation of object
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    /*
        equals() determines logical equality between objects.

        Two Person objects will be considered equal if:
        - id is same
        - name is same
    */
    @Override
    public boolean equals(Object o) {

        // Check if both references point to same object
        if (this == o) return true;

        // Check if object is null or different class
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id == person.id &&
                Objects.equals(name, person.name);
    }

    /*
        hashCode() returns hash value used by HashMap
        to determine bucket location.

        Contract rule:

        If two objects are equal according to equals(),
        they MUST return the same hashCode().
    */
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}

public class MainController {

    public static void main(String[] args) {

        /*
           HashMap with Person object as key
        */
        Map<Person, String> map = new HashMap<>();

        Person p1 = new Person("Ram", 1);
        Person p2 = new Person("Raj", 2);

        /*
           p3 has same values as p1
           so equals() will return TRUE
        */
        Person p3 = new Person("Ram", 1);

        map.put(p1, "Engineer");
        map.put(p2, "Designer");

        /*
           Since p3.equals(p1) is TRUE
           and hashCode() is same,
           HashMap will REPLACE the value of p1.
        */
        map.put(p3, "Manager");

        /*
           Map size will be 2 (not 3)
           because p1 and p3 are considered the same key.
        */
        System.out.println("Map Size : " + map.size());

        // Getting value using p1
        System.out.println("Value using p1 : " + map.get(p1));

        // Getting value using p3
        System.out.println("Value using p3 : " + map.get(p3));

        // Print complete map
        System.out.println("Complete Map : " + map);
    }
}