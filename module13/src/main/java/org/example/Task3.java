package org.example;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        getOpenTasksForUser(2);
    }

    public static void getOpenTasksForUser(int userId) {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet tasksRequest = new HttpGet(BASE_URL + "/users/" + userId + "/todos");

            HttpResponse tasksResponse = httpClient.execute(tasksRequest);
            int statusCode = tasksResponse.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                String tasksResponseBody = EntityUtils.toString(tasksResponse.getEntity());

                Task[] tasks = gson.fromJson(tasksResponseBody, Task[].class);
                List<Task> taskList = Arrays.asList(tasks);

                System.out.println("Open tasks for user " + userId + ":");
                for (Task task : taskList) {
                    if (!task.isCompleted()) {
                        System.out.println("- " + task.getTitle());
                    }
                }
            } else {
                System.out.println("Failed to get tasks for user. Status code: " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Task {
        private int id;
        private int userId;
        private String title;
        private boolean completed;

        public boolean isCompleted() {
            return completed;
        }

        public String getTitle() {
            return title;
        }
    }
}