package com.example.memo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Entity
public class Memo implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(nullable = false , updatable = false)
    private int id;
    private String title;
    private String message;
    private String creator;
    private String[] tags;
    private String image;
    private int likes = 0;
    private String createdAt;

    public Memo() {}

    public Memo(String title, String message, String creator, String[] tags, String image) {
        this.title = title;
        this.message = message;
        this.creator = creator;
        this.tags = tags;
        this.image = image;

        // format Date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = dtf.format(now);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Memo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", creator='" + creator + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", image='" + image + '\'' +
                ", likes=" + likes +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
