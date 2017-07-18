package main.java.com.examples.jaxrs.service;

/**
 * Created by krishna1bhat on 7/16/17.
 */
import main.java.com.examples.jaxrs.model.Person;
import main.java.com.examples.jaxrs.model.Response;

public interface PersonService {

    public Response addPerson(Person p);

    public Response deletePerson(int id);

    public Person getPerson(int id);

    public Person[] getAllPersons();

}