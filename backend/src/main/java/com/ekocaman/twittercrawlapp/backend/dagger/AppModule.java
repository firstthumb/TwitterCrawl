package com.ekocaman.twittercrawlapp.backend.dagger;

import com.ekocaman.twittercrawlapp.backend.service.TwitterCronService;

import java.io.IOException;
import java.util.Properties;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class AppModule {
    private Properties properties;


    public AppModule() {
        properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Provides @Singleton
    TwitterCronService provideCronService() {
        return new TwitterCronService();
    }

    @Provides @Singleton @Named("twitter.appId")
    String provideTwitterApiId() {
        return properties.getProperty("twitter.appId");
    }
}