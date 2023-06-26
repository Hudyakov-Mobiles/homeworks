package org.example;

import java.util.concurrent.Semaphore;

public class Task2 {
    private int n;
    private Semaphore fizz;
    private Semaphore buzz;
    private Semaphore fizzbuzz;
    private Semaphore numb;

    public Task2(int n) {
        this.n = n;
        fizz = new Semaphore(0);
        buzz = new Semaphore(0);
        fizzbuzz = new Semaphore(0);
        numb = new Semaphore(1);
    }

    public void fizz() throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                fizz.acquire();
                System.out.println("fizz");
                numb.release();
            }
        }
    }

    public void buzz() throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                buzz.acquire();
                System.out.println("buzz");
                numb.release();
            }
        }
    }

    public void fizzBuzz() throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            fizzbuzz.acquire();
            System.out.println("fizzbuzz");
            numb.release();
        }
    }

    public void number() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            numb.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.release();
            } else if (i % 3 == 0) {
                fizz.release();
            } else if (i % 5 == 0) {
                buzz.release();
            } else {
                System.out.println(i);
                numb.release();
            }
        }
    }

    public static void main(String[] args) {
        int n = 15;
        Task2 fizzBuzz = new Task2(n);

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzBuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
