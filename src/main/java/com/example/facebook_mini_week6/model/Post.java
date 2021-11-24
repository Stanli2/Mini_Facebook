package com.example.facebook_mini_week6.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Post {
    private int post_id;
    private String message;
    private int userid;


    public Post(int userid, String message) {
        this.userid = userid;
        this.message = message;
    }

    public Post(String message) {
        this.message = message;
    }
}
