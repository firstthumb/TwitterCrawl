package com.ekocaman.twittercrawlapp.backend.service;

import com.ekocaman.twittercrawlapp.backend.TwitterClientBuilder;
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
import java.util.concurrent.TimeUnit;

import twitter4j.StatusListener;

public class TwitterService {
    private static Logger logger = LoggerFactory.getLogger(TwitterService.class);

    private StatusListener listener;
    private BasicClient client;
    private ExecutorService service;

    public void connect(StatusListener listener) {
        logger.info("Opening connection to Twitter");

        this.listener = listener;
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10000);
        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        endpoint.stallWarnings(false);
        endpoint.followings(Lists.newArrayList(370031741L, 427202134L, 34557765L, 14189162L, 891438487L, 143409264L,
                19352690L, 265997924L, 369748206L, 204365156L, 133047531L, 2894852416L, 14342865L, 43854330L, 112289834L, 427464995L, 917311778L, 91581387L, 4175541L, 24870539L, 164081884L,
                269740788L, 469383441L, 16891384L, 81206447L, 5963542L, 1568884670L, 91814617L, 1397791753L, 607384486L, 275648020L, 16150760L, 507185622L, 22365919L,
                1074191400L, 43490757L, 15213501L, 14459351L, 60986611L, 1898057280L, 2479595598L, 283224276L,
                20402945L, 14212316L, 23431058L, 97734515L, 105427788L, 234482705L, 17620820L, 113130846L, 2725644498L,
                72120862L, 2187405908L, 567344749L, 53333911L, 23557073L, 123089696L, 341393844L, 14524078L, 26244954L, 243381107L, 237162017L));


        Authentication auth = new OAuth1("", "", "", "");
        client = new TwitterClientBuilder()
                .name("TwitterServiceClient")
                .hosts(Constants.USERSTREAM_HOST)
                .endpoint(endpoint)
                .authentication(auth)
                .processor(new StringDelimitedProcessor(queue))
                .build();

        service = Executors.newSingleThreadExecutor(ThreadManager.currentRequestThreadFactory());
        Twitter4jStatusClient t4jClient = new Twitter4jStatusClient(
                client, queue, Lists.newArrayList(listener), service);


        t4jClient.connect();
        t4jClient.process();


        logger.info("Connection opened successfully");
    }

    public void disconnect() {
        if (client != null) {
            logger.info("Closing connection");
            client.stop();
            try {
                service.awaitTermination(60, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Closed connection");
        }
    }

    public void setListener(StatusListener listener) {
        this.listener = listener;
    }
}
