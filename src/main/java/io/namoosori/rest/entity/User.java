package io.namoosori.rest.entity;

import com.google.gson.Gson;
import lombok.Data;
import java.util.UUID;

@Data
public class User {

    private String id;
    private String name;
    private String email;

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String name, String email) {
        this();
        this.name = name;
        this.email = email;
    }

    public static User sample() {
        return new User("Park", "park@namoosori.io");
    }

    public static void main(String[] args) {
        User user = new User("Kim", "kim@namoosori.io");
        System.out.println(new Gson().toJson(user));
    }
}
