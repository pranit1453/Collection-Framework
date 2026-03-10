package com.demo.arraylist.controller;

import com.demo.arraylist.service.ArrayListService;
import com.demo.arraylist.service.IArrayListService;

import java.util.ArrayList;

public class MainController {
    static void main() {
        IArrayListService service = new ArrayListService();

        ArrayList<Integer> list = new ArrayList<>();
        service.methodsOfArrayList(list);
    }
}
