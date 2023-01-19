package com.Instagram.social.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "Instagram")

public class User {
    @Id
    private  String userId;
    private  String userName;
    private  String followingCount;
    private String  followersCount;
}


