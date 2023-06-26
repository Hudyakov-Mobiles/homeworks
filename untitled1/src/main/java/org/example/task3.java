package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class task3 {
    public static void readWordsFromFile(){
        String fileName = "words.txt";

        Map<String, Integer> wordFrequencyMap = getWordFrequency(fileName);

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordFrequencyMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static Map<String, Integer> getWordFrequency(String fileName) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordFrequencyMap;
    }
}
