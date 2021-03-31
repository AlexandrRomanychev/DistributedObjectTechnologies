package rest.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.junit.jupiter.api.*;
import ru.krista.personinfo.Address;
import ru.krista.personinfo.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestClientTest {

    private OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @Order(1)
    public void getAllPersons() throws IOException {
        Request request = new Request.Builder().url("http://localhost:8080/persons/").build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        List<Person> persons = objectMapper.readValue(responseBody.string(), List.class);
        Assertions.assertEquals(2, persons.size());
    }

    @Test
    @Order(2)
    public void getSecondPerson() throws IOException {
        Request request = new Request.Builder().url("http://localhost:8080/persons/person/1").build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        Person person = objectMapper.readValue(responseBody.string(), Person.class);
        Person expectedPerson = new Person("Sam1", "Jackson1", new Address("street2", "Yaroslavl1", 1233), new ArrayList<>());
        Assertions.assertEquals(person, expectedPerson);
    }

    @Test
    @Order(3)
    public void createPerson() throws IOException {
        Request request = new Request.Builder().url("http://localhost:8080/persons/new_person").post(RequestBody.create(MediaType
                .parse("application/json"), "")).build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        List<Person> person = objectMapper.readValue(responseBody.string(), List.class);
        Assertions.assertEquals(3, person.size());
    }

    @Test
    @Order(4)
    public void deleteSecondPerson() throws IOException {
        Request request = new Request.Builder().url("http://localhost:8080/persons/delete/1").delete().build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        Person person = objectMapper.readValue(responseBody.string(), Person.class);
        Person expectedPerson = new Person("Sam1", "Jackson1", new Address("street2", "Yaroslavl1", 1233), new ArrayList<>());
        Assertions.assertEquals(expectedPerson, person);
    }

    @Test
    @Order(5)
    public void updateFirstPerson() throws IOException {
        Request request = new Request.Builder().url("http://localhost:8080/persons/update/0/name/surname").post(RequestBody.create(MediaType
                .parse("application/json"), "")).build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        Person person = objectMapper.readValue(responseBody.string(), Person.class);
        Person expectedPerson = new Person("name", "surname", new Address("street1", "Yaroslavl", 123), new ArrayList<>());
        Assertions.assertEquals(expectedPerson, person);
    }
}
