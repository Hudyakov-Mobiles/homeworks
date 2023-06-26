package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    private static final Gson gson = new GsonBuilder().create();
    public static void main(String[] args) {
        createUser();
        updateUser();
        deleteUser();
        getAllUsers();
        getUserById(3);
        getUserByUsername("Artem");
    }

    public static void createUser() {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(BASE_URL);

            User newUser = new User("Oleh Olehov", "oleholehov@example.com");

            String requestBody = gson.toJson(newUser);

            request.setHeader("Content-type", "application/json");
            request.setEntity(new StringEntity(requestBody));

            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 201) {
                String responseBody = EntityUtils.toString(response.getEntity());
                User createdUser = gson.fromJson(responseBody, User.class);
                System.out.println("User created: " + createdUser);
            } else {
                System.out.println("Failed to create user. Status code: " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser() {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPut request = new HttpPut(BASE_URL + "/1");

            User updatedUser = new User("Updated Oleh", "updatedoleh@example.com");

            String requestBody = gson.toJson(updatedUser);

            request.setHeader("Content-type", "application/json");
            request.setEntity(new StringEntity(requestBody));

            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());
                User updatedUserResponse = gson.fromJson(responseBody, User.class);
                System.out.println("User updated: " + updatedUserResponse);
            } else {
                System.out.println("Failed to update user. Status code: " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser() {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpDelete request = new HttpDelete(BASE_URL + "/1");

            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode >= 200 && statusCode < 300) {
                System.out.println("User deleted successfully");
            } else {
                System.out.println("Failed to delete user. Status code: " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getAllUsers() {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(BASE_URL);

            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());

                User[] users = gson.fromJson(responseBody, User[].class);
                List<User> userList = Arrays.asList(users);

                System.out.println("All users: " + userList);
            } else {
                System.out.println("Failed to get all users. Status code: " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getUserById(int id) {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(BASE_URL + "/" + id);

            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());
                User user = gson.fromJson(responseBody, User.class);
                System.out.println("User with id " + id + ": " + user);
            } else {
                System.out.println("Failed to get user by id. Status code: " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getUserByUsername(String username) {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(BASE_URL + "?username=" + username);

            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());

                User[] users = gson.fromJson(responseBody, User[].class);
                List<User> userList = Arrays.asList(users);

                System.out.println("User(s) with username " + username + ": " + userList);
            } else {
                System.out.println("Failed to get user by username. Status code: " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class User {
        private int id;
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{ " +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    " }";
        }
    }
}