package com.ekocaman.twittercrawlapp.backend.service;

import com.ekocaman.twittercrawlapp.backend.TwitterClientBuilder;
import com.ekocaman.twittercrawlapp.backend.entity.TweetEntity;
import com.ekocaman.twittercrawlapp.backend.entity.TwitterCronEntity;
import com.google.appengine.api.ThreadManager;
import com.google.common.collect.Lists;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.BasicClient;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import com.twitter.hbc.twitter4j.Twitter4jStatusClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import javax.inject.Inject;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class TwitterCronService extends AbstractService<TwitterCronEntity> {
    private static Logger logger = LoggerFactory.getLogger(TwitterCronService.class);

    private final TweetService tweetService;

    @Inject
    public TwitterCronService(TweetService tweetService) {
        super(TwitterCronEntity.class);
        this.tweetService = tweetService;
    }

    
}
