package com.javaworld.hotels.businessobjects;


public class Hotel {
    private java.lang.String name;

    private java.lang.String address;

    private java.lang.String city;

    private int stars;

    public Hotel() {
        super();
    }

    public Hotel(java.lang.String name ,java.lang.String address ,java.lang.String city ,int stars) {
        super();
        com.javaworld.hotels.businessobjects.Hotel.this.name = name;
        com.javaworld.hotels.businessobjects.Hotel.this.address = address;
        com.javaworld.hotels.businessobjects.Hotel.this.city = city;
        com.javaworld.hotels.businessobjects.Hotel.this.stars = stars;
    }

    public java.lang.String getAddress() {
        return address;
    }

    public void setAddress(java.lang.String address) {
        com.javaworld.hotels.businessobjects.Hotel.this.address = address;
    }

    public java.lang.String getCity() {
        return city;
    }

    public void setCity(java.lang.String city) {
        com.javaworld.hotels.businessobjects.Hotel.this.city = city;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        com.javaworld.hotels.businessobjects.Hotel.this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        com.javaworld.hotels.businessobjects.Hotel.this.stars = stars;
    }
}

