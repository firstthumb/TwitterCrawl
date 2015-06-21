package com.ekocaman.twittercrawlapp.backend.task;

import com.ekocaman.twittercrawlapp.backend.dagger.AbstractServlet;
import com.google.appengine.api.taskqueue.DeferredTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FetchTweetsTask extends AbstractServlet implements DeferredTask {
    Logger logger = LoggerFactory.getLogger(FetchTweetsTask.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Running Task");

        myComponent.getCronService().connect();

        resp.setContentType("text/plain");
        resp.getWriter().write("OK");
    }

    @Override
    public void run() {

    }
}
