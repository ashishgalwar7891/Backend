package org.example.domain;

public class Address {
    int doorNO;
    String street;
    String city;
    public Address(){

    }

    public Address(int doorNO, String street, String city) {
        this.doorNO = doorNO;
        this.street = street;
        this.city = city;
    }

    public int getDoorNO() {
        return doorNO;
    }

    public void setDoorNO(int doorNO) {
        this.doorNO = doorNO;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "doorNO=" + doorNO +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
