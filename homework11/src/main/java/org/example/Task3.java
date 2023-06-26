package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

    public class Task3 {
        public static void main(String[] args) {
            String[] array = {"1, 2, 0", "4, 5"};
            String result = sortAndFormatNumbers(array);
            System.out.println(result);
        }

        private static String sortAndFormatNumbers(String[] array) {
            return Arrays.stream(array)
                    .flatMap(s -> Arrays.stream(s.split(",\\s*")))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));
        }
    }
