package org.example;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        long seed = 0L;

        Stream<Long> randomStream = generateRandomStream(a, c, m, seed);
        randomStream.limit(10).forEach(System.out::println);
    }

    private static Stream<Long> generateRandomStream(long a, long c, long m, long seed) {
            return Stream.iterate(seed, x -> (a * x + c) % m);
    }
}

