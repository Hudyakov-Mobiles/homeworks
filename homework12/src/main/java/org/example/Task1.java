package org.example;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task1{
    static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    static long startTime = System.currentTimeMillis();

    public static void main(String[] args) {
        scheduler.scheduleAtFixedRate(() -> {
            int count = (int) ((System.currentTimeMillis() - startTime) / 1000);
            System.out.println("Thread 1: Прошло " + count + " секунд");
        }, 0, 1, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Thread 2: Прошло 5 секунд");
        }, 5, 5, TimeUnit.SECONDS);
    }
}
