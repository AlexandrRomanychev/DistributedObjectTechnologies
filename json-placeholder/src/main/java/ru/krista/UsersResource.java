package ru.krista;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import ru.krista.pojo.ExtendedPerson;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/users")
public class UsersResource {

    @Inject
    @RestClient
    UsersService usersService;

    public UsersResource() {
    }

    @GET
    public Set<ExtendedPerson> list() {
        return usersService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ExtendedPerson id(@PathParam String id) {
        return usersService.getById(id);
    }
}