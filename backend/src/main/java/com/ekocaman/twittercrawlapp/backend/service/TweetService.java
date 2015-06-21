package com.ekocaman.twittercrawlapp.backend.service;

import com.ekocaman.twittercrawlapp.backend.entity.TweetEntity;

public class TweetService extends AbstractService<TweetEntity> {

    public TweetService() {
        super(TweetEntity.class);
    }
}
