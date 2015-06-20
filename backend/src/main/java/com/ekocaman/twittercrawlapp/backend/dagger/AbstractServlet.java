package com.ekocaman.twittercrawlapp.backend.dagger;

import javax.servlet.http.HttpServlet;


public class AbstractServlet extends HttpServlet {

    protected ServiceComponent myComponent;

    @Override
    public void init() {
        myComponent = (ServiceComponent) getServletContext().getAttribute("myComponent");
    }
}
