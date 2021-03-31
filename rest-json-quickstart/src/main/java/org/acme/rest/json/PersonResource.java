package org.acme.rest.json;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import ru.krista.personinfo.Address;
import ru.krista.personinfo.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Path("/persons")
public class PersonResource {

    List<Person> persons = new ArrayList<>();

    private Person createPerson() {
        Person person = new Person();
        person.setName(UUID.randomUUID().toString());
        person.setLastName(UUID.randomUUID().toString());
        person.setAddress(new Address(UUID.randomUUID().toString(), UUID.randomUUID().toString(), new Random().nextInt()));
        person.setPhoneNumbers(new ArrayList<String>());
        return person;
    }

    public PersonResource() {
        persons.add(new Person("Sam", "Jackson", new Address("street1", "Yaroslavl", 123), new ArrayList<>()));
        persons.add(new Person("Sam1", "Jackson1", new Address("street2", "Yaroslavl1", 1233), new ArrayList<>()));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        return persons;
    }

    @GET
    @Path("/person/{position}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam int position) {
        if (position >= persons.size())
            return persons.get(persons.size()-1);
        return persons.get(position);
    }

    @POST
    @Path("/new_person")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> createNewPerson() {
        persons.add(createPerson());
        return persons;
    }

    @DELETE
    @Path("/delete/{position}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person deletePerson(@PathParam int position) {
        if (position < persons.size()) {
            Person person = persons.get(position);
            persons.remove(position);
            return person;
        }
        return persons.get(persons.size()-1);
    }

    @POST
    @Path("/update/{person_number}/{name}/{surname}")
    public Person updatePerson(@PathParam int person_number, @PathParam String name, @PathParam String surname) {
        if (person_number < persons.size()) {
            Person person = persons.get(person_number);
            persons.remove(person_number);
            person.setName(name);
            person.setLastName(surname);
            return person;
        }
        return persons.get(persons.size()-1);
    }
}