package com.ekocaman.twittercrawlapp.backend.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.Date;

@Entity
public class TweetEntity {

    @Id
    private Long id;

    private String text;
    private long userId;
    private String screenName;
    private Date creationDate;

    public TweetEntity() {

    }

    public TweetEntity(Long id, String text, long userId, String screenName, Date creationDate) {
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.screenName = screenName;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "TweetEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", userId=" + userId +
                ", screenName='" + screenName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}