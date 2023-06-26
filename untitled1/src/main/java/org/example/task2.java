package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;

public class task2 {
    private static List<User> userList = new ArrayList<>();
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void readFile() {
        String fileName = "file2.txt";
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            boolean isFirstLine = true;
            String[] header = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstLine) {
                    header = line.split(" ");
                    isFirstLine = false;
                }  else {
                    String[] values = line.split(" ");
                    User user = new User(values[0], Integer.parseInt(values[1]));
                    userList.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeJson() {
        String json = gson.toJson(userList);
        String fileName = "user.json";

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
