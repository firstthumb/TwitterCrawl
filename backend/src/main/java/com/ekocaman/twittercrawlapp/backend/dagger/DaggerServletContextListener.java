package com.ekocaman.twittercrawlapp.backend.dagger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class DaggerServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServiceComponent myComponent = DaggerServiceComponent.builder().build();

//        ObjectGraph objectGraph = ObjectGraph.create(new AppModule());
        sce.getServletContext().setAttribute("myComponent", myComponent);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }


}
