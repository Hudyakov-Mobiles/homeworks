package org.example;

public class Main {
    public static void main(String[] args) {
        task1.readFile();
        System.out.println("___________________________");

        task2.readFile();
        task2.writeJson();

        task3.readWordsFromFile();
    }
}