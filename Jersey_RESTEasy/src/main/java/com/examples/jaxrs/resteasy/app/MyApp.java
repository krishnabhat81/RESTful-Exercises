package main.java.com.examples.jaxrs.resteasy.app;

/**
 * Created by krishna1bhat on 7/16/17.
 */
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import main.java.com.examples.jaxrs.service.PersonServiceImpl;

//source: journaldev
public class MyApp extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public MyApp() {
        singletons.add(new PersonServiceImpl());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}