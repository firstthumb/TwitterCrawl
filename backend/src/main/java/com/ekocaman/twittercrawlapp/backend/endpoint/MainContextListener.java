package com.ekocaman.twittercrawlapp.backend.endpoint;

import com.ekocaman.twittercrawlapp.backend.dagger.ServiceComponent;
import com.google.api.server.spi.guice.GuiceSystemServiceServletModule;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.servlet.GuiceServletContextListener;

import javax.inject.Singleton;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class MainContextListener extends GuiceServletContextListener {


    private ServletContext servletContext = null;

    public MainContextListener() {}

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContext = servletContextEvent.getServletContext();
        super.contextInitialized(servletContextEvent);

    }

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new MainServletModule(), new MainModule());
    }

    private class MainServletModule extends GuiceSystemServiceServletModule {
        private ServiceComponent myComponent;

        public MainServletModule() {
            myComponent = (ServiceComponent) servletContext.getAttribute("myComponent");
            System.out.println("MainServletModule : " + myComponent);
        }

        @Override protected void configureServlets() {
            super.configureServlets();

            Set<Class<?>> serviceClasses = new HashSet<>();
            serviceClasses.add(CronEndpoint.class);
            // add endpoint classes
            //    i.e., serviceClasses.add(AccountV1.class);
            this.serveGuiceSystemServiceServlet("/_ah/spi/*", serviceClasses);

            // filters, generic bindings
            //   i.e., filter("/*").through(ObjectifyFilter.class);
            // serve bindings
            //   serve("path").with(Servlet.class);

            binder().bind(ServiceComponent.class).toInstance(myComponent);
        }

    }

    private static class MainModule extends AbstractModule {
        @Override
        protected void configure() {
            // misc injection, i.e., an ObjectifyFilter and ObjectifyFactor
        }
    }

    private class MainWebModule extends AbstractModule {
        private ServiceComponent myComponent;

        public MainWebModule(ServletContext servletContext) {
            myComponent = (ServiceComponent) servletContext.getAttribute("myComponent");
        }

//        @Provides @Singleton
//        ServiceComponent provideServiceComponent() {
//            return myComponent;
//        }

        @Override
        protected void configure() {
            binder().bind(ServiceComponent.class).toInstance(myComponent);
        }
    }


//    private class MainShiroWebModule extends ShiroWebModule {
//
//        public MainShiroWebModule(ServletContext servletContext) {
//            super(servletContext);
//        }
//
//        @Override
//        protected void configureShiroWeb() {
//            // Shiro class binding
//            //  i.e., bind(SessionDAO.class).to(EnterpriseCacheSessionDAO.class);
//
//            // Shiro realm binding
//            //  i.e., bindRealm().to(DatabaseRealm.class);
//            //  try/catch!
//
//            // Shiro filter chains
//            //   Always remember to define your filter chains based on a FIRST MATCH WINS policy!
//            //   Should work with App Engine Cloud Endpoints
//            //   i.e.:
//            //     addFilterChain("/logout", LOGOUT);
//            //     addFilterChain("/_ah/api/myapi/v1/account/logout", NO_SESSION_CREATION, TOKEN_LOGOUT);
//        }
//
//        @Provides @Singleton
//        Ini loadShiroIni() throws MalformedURLException {
//            URL iniUrl = servletContext.getResource("/WEB-INF/shiro.ini");
//            return Ini.fromResourcePath("url:" + iniUrl.toExternalForm());
//        }
//
//    }

}
