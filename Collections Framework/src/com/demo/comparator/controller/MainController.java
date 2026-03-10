package com.demo.comparator.controller;

import com.demo.comparator.service.ComparatorService;
import com.demo.comparator.service.IComparatorService;

import java.util.Arrays;
import java.util.List;

public class MainController {
    static void main() {
        IComparatorService service = new ComparatorService();
        List<String> list = Arrays.asList("Banana","Apple","Date");

        service.sortingLogicComparator(list);
    }
}
