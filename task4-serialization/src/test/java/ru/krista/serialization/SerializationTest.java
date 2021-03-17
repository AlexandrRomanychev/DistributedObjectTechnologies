package ru.krista.serialization;

import org.junit.Before;
import org.junit.Test;
import ru.krista.personinfo.Address;
import ru.krista.personinfo.Person;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SerializationTest {

    private Person person;

    @Before
    public void createPerson() {
        Address address = new Address("Московское ш., 101", "Ленинград", 101101);
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("812 123-1234");
        phoneNumbers.add("916 123-4567");
        person = new Person("Иван", "Иванов", address, phoneNumbers);
    }

    @Test
    public void jsonSerializationPerson() {
        JsonSerialization serializator = new JsonSerialization();
        String serializingString = serializator.serialize(person);
        Person result = (Person)serializator.deserialize(serializingString, Person.class);
        assertNotNull(result);
        assertEquals(person, result);
    }

    @Test
    public void jsonDeserializationPerson() {
        String serializingStr = "{\"name\":\"Иван\",\"lastName\":\"Иванов\",\"address\":{\"streetAddress\":\"Московское ш., 101\",\"city\":\"Ленинград\",\"postalCode\":101101},\"phoneNumbers\":[\"812 123-1234\",\"916 123-4567\"]}";
        JsonSerialization serializator = new JsonSerialization();
        Object object = serializator.deserialize(serializingStr, Person.class);
        assertNotNull(object);
        String result = serializator.serialize(object);
        assertEquals(serializingStr, result);
    }

    @Test
    public void xmlSerializationAddress() {
        XmlSerialization serializator = new XmlSerialization();
        Address address = person.getAddress();
        String serializingString = serializator.serialize(address);
        Address result = (Address) serializator.deserialize(serializingString, Address.class);
        assertNotNull(result);
        assertEquals(address, result);
    }

    @Test
    public void xmlDeserializationAddress() {
        String xmlString = "<Address><streetAddress>Московское ш., 101</streetAddress><city>Ленинград</city><postalCode>101101</postalCode></Address>";
        XmlSerialization xmlSerialization = new XmlSerialization();
        Object object = xmlSerialization.deserialize(xmlString, Address.class);
        assertNotNull(object);
        String result = xmlSerialization.serialize(object);
        assertEquals(xmlString, result);
    }

    @Test
    public void messagePackSerializationPerson() {
        MessagePackSerialization mesPackSerialization = new MessagePackSerialization();
        byte[] serializing = mesPackSerialization.serialization(person);
        Person result = (Person)mesPackSerialization.deserialization(serializing, Person.class);
        assertNotNull(result);
        assertEquals(person, result);
    }

    @Test
    public void messagePackDeserializationPerson() {
        byte[] serializing = new byte[]{-108, -88, -48, -104, -48, -78, -48, -80, -48, -67, -84, -48, -104, -48, -78, -48, -80, -48, -67, -48, -66, -48, -78, -109, -67, -48, -100, -48, -66, -47, -127, -48, -70, -48, -66, -48, -78, -47, -127, -48, -70, -48, -66, -48, -75, 32, -47, -120, 46, 44, 32, 49, 48, 49, -78, -48, -101, -48, -75, -48, -67, -48, -72, -48, -67, -48, -77, -47, -128, -48, -80, -48, -76, -50, 0, 1, -118, -19, -110, -84, 56, 49, 50, 32, 49, 50, 51, 45, 49, 50, 51, 52, -84, 57, 49, 54, 32, 49, 50, 51, 45, 52, 53, 54, 55};
        MessagePackSerialization serializator = new MessagePackSerialization();
        Person object = (Person)serializator.deserialization(serializing, Person.class);
        assertNotNull(object);
        byte[] result = serializator.serialization(object);
        assertArrayEquals(serializing, result);
    }
}
