package com.ekocaman.twittercrawlapp.backend.dagger;

import com.ekocaman.twittercrawlapp.backend.service.TwitterCronService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AppModule.class })
public interface ServiceComponent {

    TwitterCronService getCronService();

    @Named("twitter.appId")
    String getTwitterAppId();
}
