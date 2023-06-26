package org.example;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class task1 {
    static List<String> numList = new ArrayList<>();
    private static StringBuilder numberString = new StringBuilder();
    public static <Char> void readFile() {
        try (FileReader reader = new FileReader("file1.txt")) {
            int c;
            char ch;
            while ((c = reader.read()) != -1) {
                ch = (char) c;
                if (ch != '\n') {
                    numberString.append(ch);
                }
                else {
                    numList.add(numberString.toString());
                    numberString.setLength(0);
                }
            }
            numList.add(numberString.toString());
            String numStripped;
            for (int i = 0; i < numList.size(); i++) {
                numStripped = numList.get(i).replace(" ", "");
                if ((numStripped.charAt(0) == '(' &&
                        numStripped.charAt(4) == ')' &&
                        numStripped.charAt(8) == '-') ||
                        (numStripped.charAt(3) == '-' && numStripped.charAt(7) == '-')) {
                    System.out.println(numStripped);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
