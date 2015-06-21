package com.ekocaman.twittercrawlapp.backend;

import com.ekocaman.twittercrawlapp.backend.dagger.AbstractServlet;
import com.google.appengine.api.ThreadManager;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.endpoint.StatusesSampleEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.BasicClient;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class TwitterList extends AbstractServlet {

    private static int COUNTER = 0;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

//        myComponent.getTwitterService().connect(new StatusListener() {
//            @Override
//            public void onStatus(Status status) {
//                try {
//                    System.out.println(status);
//                    resp.getWriter().write(status.toString());
//                    resp.getWriter().write("</br></br></br></br>");
//                    resp.getWriter().flush();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
//
//            }
//
//            @Override
//            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
//
//            }
//
//            @Override
//            public void onScrubGeo(long userId, long upToStatusId) {
//
//            }
//
//            @Override
//            public void onStallWarning(StallWarning warning) {
//
//            }
//
//            @Override
//            public void onException(Exception ex) {
//
//            }
//        });
//
//        try {
//            Thread.sleep(1 * 30 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        myComponent.getTwitterService().disconnect();

//        ExecutorService service = Executors.newSingleThreadExecutor(ThreadManager.currentRequestThreadFactory());
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                resp.getWriter().write("COUNT : " + COUNTER++ + "   ");
//            }
//        }
//        service.submit()

        resp.getWriter().write("OK");
    }
}

