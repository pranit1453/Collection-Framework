package com.demo.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class MainController {

    public static void main(String[] args) {
        // Stack extends Vector
        /* -------------------------------------------------
           1. Using Java Stack Class (LIFO - Last In First Out)
           ------------------------------------------------- */

        Stack<Integer> stack = new Stack<>();

        // push() → adds element to top of stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Initial Stack : " + stack);

        // pop() → removes top element
        Integer removedElement = stack.pop();
        System.out.println("Removed Element : " + removedElement);
        System.out.println("Stack After Pop : " + stack);

        // peek() → returns top element without removing
        Integer peek = stack.peek();
        System.out.println("Peek Element : " + peek);

        System.out.println("Stack After Peek : " + stack);

        // check if stack is empty
        System.out.println("Is Stack Empty : " + stack.isEmpty());

        // size of stack
        System.out.println("Stack Size : " + stack.size());

        // search() → returns position from top (1-based index)
        int search = stack.search(3);
        System.out.println("Position of element 3 from top : " + search);


        /* -------------------------------------------------
           Example of LIFO behavior
           -------------------------------------------------

           push order : 1 → 2 → 3 → 4

           pop order :
           4
           3
           2
           1
        */


        /* -------------------------------------------------
           2. Using LinkedList as Stack (Recommended)
           -------------------------------------------------

           LinkedList implements Deque interface
           which supports stack operations.
        */

        LinkedList<Integer> linkedList = new LinkedList<>();

        // push elements
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        // peek (get last element)
        Integer linkedPeek = linkedList.getLast();

        // pop (remove last element)
        Integer linkedPop = linkedList.removeLast();

        int linkedSize = linkedList.size();
        boolean linkedEmpty = linkedList.isEmpty();


        /* -------------------------------------------------
           3. Using ArrayList as Stack
           -------------------------------------------------

           ArrayList does not directly support stack methods
           but we can simulate stack using last index.
        */

        ArrayList<Integer> arrayList = new ArrayList<>();

        // push
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        // peek (last element)
        Integer arrayPeek = arrayList.get(arrayList.size() - 1);

        // pop (remove last element)
        Integer arrayPop = arrayList.remove(arrayList.size() - 1);

        int arraySize = arrayList.size();
        boolean arrayEmpty = arrayList.isEmpty();


        /* -------------------------------------------------
           Time Complexity
           -------------------------------------------------

           push()   → O(1)
           pop()    → O(1)
           peek()   → O(1)
           search() → O(n)

         */


        /* -------------------------------------------------
           Important Note (Modern Java Recommendation)
           -------------------------------------------------

           Stack class is considered legacy.

           Preferred approach:

           Deque<Integer> stack = new ArrayDeque<>();

           Methods:
           push()
           pop()
           peek()

         */
    }
}