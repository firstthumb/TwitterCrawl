package com.ekocaman.twittercrawlapp.backend.dagger;

import com.ekocaman.twittercrawlapp.backend.service.TwitterCronService;
import com.ekocaman.twittercrawlapp.backend.service.TwitterService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AppModule.class })
public interface ServiceComponent {

    TwitterCronService getCronService();

    TwitterService getTwitterService();

    @Named("twitter.appId")
    String getTwitterAppId();
}
