package com.ekocaman.twittercrawlapp.backend.endpoint;

import com.ekocaman.twittercrawlapp.backend.dagger.ServiceComponent;
import com.ekocaman.twittercrawlapp.backend.entity.TwitterCronEntity;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.googlecode.objectify.Key;

import java.util.List;

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

    @ApiMethod(name = "getCron", httpMethod = ApiMethod.HttpMethod.GET)
    public TwitterCronEntity get(@Named("id") Long id) {
        return serviceComponent.getCronService().findById(id);
    }

    @ApiMethod(name = "list", httpMethod = ApiMethod.HttpMethod.GET)
    public List<TwitterCronEntity> getAll() {
        return serviceComponent.getCronService().findAll();
    }

    @ApiMethod(name = "add", httpMethod = ApiMethod.HttpMethod.POST)
    public TwitterCronEntity save(TwitterCronEntity entity) {
        Key<TwitterCronEntity> key = serviceComponent.getCronService().save(entity);
        return serviceComponent.getCronService().find(key);
    }

    @ApiMethod(name = "remove", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void delete(@Named("id") Long id) {
        TwitterCronEntity entity = serviceComponent.getCronService().findById(id);
        serviceComponent.getCronService().delete(entity);
    }

    @ApiMethod(name = "update", httpMethod = ApiMethod.HttpMethod.PUT)
    public TwitterCronEntity update(TwitterCronEntity updatedEntity) {
        TwitterCronEntity entity = serviceComponent.getCronService().findById(updatedEntity.getId());
        entity.setStartDate(updatedEntity.getStartDate());
        entity.setCompletionDate(updatedEntity.getCompletionDate());
        entity.setCompleted(updatedEntity.isCompleted());
        serviceComponent.getCronService().save(entity);
        return entity;
    }
}
