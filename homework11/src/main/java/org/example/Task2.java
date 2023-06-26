package org.example;

import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "John", "Peter", "Alice", "Michael");
        List<String> result = convertAndSort(names);
        System.out.println(result);
    }
    private static List<String> convertAndSort(List<String> names) {
        List<String> res = names.stream()
                .map(String::toUpperCase)
                .sorted(Collections.reverseOrder()).collect(Collectors.toList());
        return res;
    }
}


