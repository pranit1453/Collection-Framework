package com.demo.garbagecollector;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;

/*
    This class represents an object created in HEAP memory.

    We will create this object using Reflection
    and later make it eligible for Garbage Collection.
*/
class Person {

    private String name;

    public Person(String name) {
        this.name = name;
        System.out.println("Person object created: " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
            toString() helps display object information
        */
    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}

public class MainController {

    public static void main(String[] args) throws Exception {

        /*
        ---------------------------------------------------------
        1. Loading class dynamically using Reflection
        ---------------------------------------------------------

        Reflection allows us to:
        - Load classes at runtime
        - Create objects dynamically
        - Access constructors, fields, and methods

        Equivalent normal code:
            Person p = new Person("Ram");
        */

        Class<?> clazz = Class.forName("com.demo.garbagecollector.Person");


        /*
        ---------------------------------------------------------
        2. Get Constructor
        ---------------------------------------------------------
        */

        Constructor<?> constructor = clazz.getConstructor(String.class);


        /*
        ---------------------------------------------------------
        3. Create object using Reflection
        ---------------------------------------------------------
        */

        Person p1 = (Person) constructor.newInstance("Ram");


        /*
        ---------------------------------------------------------
        4. WeakReference
        ---------------------------------------------------------

        WeakReference allows us to check whether an object
        has been garbage collected.

        Types of references in Java:

        1. Strong Reference  (Normal objects)
        2. Weak Reference
        3. Soft Reference
        4. Phantom Reference
        */

        WeakReference<Person> weakRef = new WeakReference<>(p1);


        /*
        ---------------------------------------------------------
        5. Making object eligible for Garbage Collection
        ---------------------------------------------------------

        An object becomes eligible for GC when
        there are NO strong references pointing to it.
        */

        p1 = null;


        /*
        ---------------------------------------------------------
        6. Request Garbage Collection
        ---------------------------------------------------------

        System.gc() does NOT guarantee GC execution.
        It only suggests JVM to run GC.
        */

        System.gc();


        /*
        Wait for a moment to allow GC to run
        */
        Thread.sleep(2000);


        /*
        ---------------------------------------------------------
        7. Checking if object is collected
        ---------------------------------------------------------
        */

        if (weakRef.get() == null) {
            System.out.println("Object has been Garbage Collected");
        } else {
            System.out.println("Object still exists: " + weakRef.get());
        }

        System.out.println("End of main method");
    }
}