package com.Instagram.social.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Post")
public class Post {
    private String userId;
    @Id
    private String postId;
    private String imageUrl;
    private long likeCount;
}
