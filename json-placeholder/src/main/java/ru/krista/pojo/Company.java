package ru.krista.pojo;

public class Company {

    private String name;
    private String cathcPhrase;
    private String bs;

    public Company() {}

    public Company(String name, String cathcPhrase, String bs) {
        this.name = name;
        this.cathcPhrase = cathcPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCathcPhrase() {
        return cathcPhrase;
    }

    public void setCathcPhrase(String cathcPhrase) {
        this.cathcPhrase = cathcPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
