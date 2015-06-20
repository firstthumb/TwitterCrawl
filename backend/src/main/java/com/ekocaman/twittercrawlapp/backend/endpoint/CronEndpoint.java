package com.ekocaman.twittercrawlapp.backend.endpoint;

import com.ekocaman.twittercrawlapp.backend.dagger.ServiceComponent;
import com.ekocaman.twittercrawlapp.backend.entity.TwitterCronEntity;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Inject;
import javax.inject.Named;

@Api(name = "cron",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "backend.twittercrawlapp.ekocaman.com",
                ownerName = "backend.twittercrawlapp.ekocaman.com",
                packagePath = ""))
public class CronEndpoint {

    @Inject
    ServiceComponent serviceComponent;

    public CronEndpoint() {

    }

    @ApiMethod(name = "sayHi")
    public TwitterCronEntity sayHi(@Named("name") String name) {
        System.out.println("Service Component : " + serviceComponent);
        System.out.println("A : " + serviceComponent.getCronService());
        System.out.println("B : " + serviceComponent.getTwitterAppId());
        return new TwitterCronEntity(1L);
    }

}
