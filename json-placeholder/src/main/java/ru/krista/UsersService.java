package ru.krista;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import ru.krista.pojo.ExtendedPerson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Set;

@RegisterRestClient(configKey = "users-api")
public interface UsersService {

    @GET
    @Path("/users/")
    @Produces("application/json")
    Set<ExtendedPerson> getAll();

    @GET
    @Path("/users/{id}")
    @Produces("application/json")
    ExtendedPerson getById(@PathParam String id);
}
