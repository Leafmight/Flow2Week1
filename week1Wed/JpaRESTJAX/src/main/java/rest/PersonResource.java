/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PersonDTO;
import dto.PersonsDTO;
import entities.Person;
import exception.PersonNotFoundException;
import facade.PersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author jacobfolkehildebrandt
 */
@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;

    public PersonResource() {
    }

    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/flow2week1",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);

    private static final PersonFacade FACADE = PersonFacade.getPersonFacade(emf);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static Person p1, p2, p3;

    /**
     * Creates a new instance of PersonResource
     */
    /**
     * Retrieves representation of an instance of rest.PersonResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PersonResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

//    @GET
//    @Produces({MediaType.APPLICATION_JSON})
//    public String demo(){
//        return "{\"msg\":\"Hello World\"}";
//    }
    @Path("create")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response createPersons() {
        EntityManager em = emf.createEntityManager();

        FACADE.addPerson("Jacob", "H", "120010101");
        FACADE.addPerson("Jacob", "Hilde", "120010101");
        FACADE.addPerson("Jacob", "Hildebrandt", "120010101");

        return Response.ok().entity(GSON.toJson("Created 3 Persons")).build();
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllPersons() {
        List<Person> person = new ArrayList(FACADE.getAllPersons());
        PersonsDTO psdto = new PersonsDTO(person);

        return Response.ok().entity(GSON.toJson(psdto)).build();
    }

    @GET
    @Path("id/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPersonByID(@PathParam("id") Long id) throws PersonNotFoundException {
        Person p = FACADE.getPerson(id);
        if (p.getId() == null) {
            throw new PersonNotFoundException("No person with provided id found");
        }
        PersonDTO pdto = new PersonDTO(p);
        return Response.ok().entity(GSON.toJson(pdto)).build();

    }

    @POST
    @Path("add")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAddPerson(String person) {
        Person p = GSON.fromJson(person, Person.class);
        FACADE.addPerson(p.getFirstName(), p.getLastName(), p.getPhone());
        return Response.ok().entity(GSON.toJson(p)).build();

    }

    @DELETE
    @Path("delete")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDeletePerson(String id) throws PersonNotFoundException {
        Person p = GSON.fromJson(id, Person.class);
        FACADE.deletePerson(p.getId());
        return Response.ok().entity(GSON.toJson(p)).build();

    }

    @PUT
    @Path("edit")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEditPerson(String id) {
        Person p = GSON.fromJson(id, Person.class);
        FACADE.editPerson(p);
        return Response.ok().entity(GSON.toJson(p)).build();

    }
}
