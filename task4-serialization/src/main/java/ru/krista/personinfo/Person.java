package ru.krista.personinfo;

import org.msgpack.annotation.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Message
public class Person {
    private String name;
    private String lastName;
    private Address address;
    private List<String> phoneNumbers;

    public Person() {
        this.name = "";
        this.lastName = "";
        this.address = new Address();
        this.phoneNumbers = new ArrayList<>();
    }

    public Person(String name, String lastName, Address address, List<String> phoneNumbers) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address) && Objects.equals(phoneNumbers, person.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, address, phoneNumbers);
    }
}
