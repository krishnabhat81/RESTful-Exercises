package main.java.com.examples.jaxrs.service;

/**
 * Created by krishna1bhat on 7/16/17.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import main.java.com.examples.jaxrs.model.Person;
import main.java.com.examples.jaxrs.model.Response;

@Path("/persons")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class PersonServiceImpl implements PersonService {

    private static Map<Integer,Person> persons = new HashMap<Integer,Person>();

    @Override
    @POST
    public Response addPerson(Person p) {
        Response response = new Response();
        if(persons.get(p.getId()) != null){
            response.setStatus(false);
            response.setMessage("Person Already Exists");
            return response;
        }
        persons.put(p.getId(), p);
        response.setStatus(true);
        response.setMessage("Person created successfully");
        return response;
    }

    @Override
    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") int id) {
        Response response = new Response();
        if(persons.get(id) == null){
            response.setStatus(false);
            response.setMessage("Person Doesn't Exists");
            return response;
        }
        persons.remove(id);
        response.setStatus(true);
        response.setMessage("Person deleted successfully");
        return response;
    }

    @Override
    @GET
    @Path("/{id}")
    public Person getPerson(@PathParam("id") int id) {
        return persons.get(id);
    }

    @GET
    @Path("/dummy")
    public Person getDummyPerson() {
        Person p = new Person();
        p.setAge(99);
        p.setName("Dummy");
        p.setId(1);
        return p;
    }

    @Override
    @GET
    public Person[] getAllPersons() {
        Set<Integer> ids = persons.keySet();
        Person[] p = new Person[ids.size()];
        int i=0;
        for(Integer id : ids){
            p[i] = persons.get(id);
            i++;
        }
        return p;
    }

}