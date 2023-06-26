package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Task2 {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private static Gson gson = new Gson();

    public static void main(String[] args) {
        getCommentsForLastPost(3);
    }

    private static void getCommentsForLastPost(int userId) {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet postsRequest = new HttpGet(BASE_URL + "/users/" + userId + "/posts");

            HttpResponse postsResponse = httpClient.execute(postsRequest);
            int statusCode = postsResponse.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                String postsResponseBody = EntityUtils.toString(postsResponse.getEntity());

                Post[] posts = gson.fromJson(postsResponseBody, Post[].class);

                if (posts.length > 0) {
                    Post lastPost = posts[posts.length - 1];

                    HttpGet commentsRequest = new HttpGet(BASE_URL + "/posts/" + lastPost.getId() + "/comments");

                    HttpResponse commentsResponse = httpClient.execute(commentsRequest);
                    int commentsStatusCode = commentsResponse.getStatusLine().getStatusCode();

                    if (commentsStatusCode == 200) {
                        String commentsResponseBody = EntityUtils.toString(commentsResponse.getEntity());

                        String fileName = "user-" + userId + "-post-" + lastPost.getId() + "-comments.json";

                        try (Writer writer = new FileWriter(fileName)) {
                            writer.write(commentsResponseBody);
                            writer.close();
                            System.out.println("Comments for user " + userId + ", post " + lastPost.getId() +
                                    " saved to file: " + fileName);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Failed to get comments for post. Status code: " + commentsStatusCode);
                    }
                } else {
                    System.out.println("User has no posts");
                }
            } else {
                System.out.println("Failed to get user posts. Status code: " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Post {
        private int id;

        public int getId() {
            return id;
        }
    }
}