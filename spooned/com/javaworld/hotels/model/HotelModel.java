package com.javaworld.hotels.model;


public class HotelModel {
    private static java.lang.String[] cities = new java.lang.String[]{ "Paris" , "London" };

    private static com.javaworld.hotels.businessobjects.Hotel[] hotels = new com.javaworld.hotels.businessobjects.Hotel[]{ new com.javaworld.hotels.businessobjects.Hotel("Hotel Latin" , "Quartier latin" , "Paris" , 3) , new com.javaworld.hotels.businessobjects.Hotel("Hotel Etoile" , "Place de l'Etoile" , "Paris" , 4) , new com.javaworld.hotels.businessobjects.Hotel("Hotel Vendome" , "Place Vendome" , "Paris" , 5) , new com.javaworld.hotels.businessobjects.Hotel("Hotel Hilton" , "Trafalgar Square" , "London" , 4) , new com.javaworld.hotels.businessobjects.Hotel("Hotel Ibis" , "The City" , "London" , 3) , new com.javaworld.hotels.businessobjects.Hotel("Hotel Cigogne" , "Grand place" , "Paris" , 2) };

    public java.util.List<com.javaworld.hotels.businessobjects.Hotel> findHotelsByCity(java.lang.String city) {
        java.util.List<com.javaworld.hotels.businessobjects.Hotel> hotelsFound = new java.util.ArrayList<com.javaworld.hotels.businessobjects.Hotel>();
        for (com.javaworld.hotels.businessobjects.Hotel hotel : com.javaworld.hotels.model.HotelModel.hotels) {
            if (hotel.getCity().equalsIgnoreCase(city)) {
                hotelsFound.add(hotel);
            } 
        }
        return hotelsFound;
    }

    public java.lang.String[] findAvailableCities() {
        return com.javaworld.hotels.model.HotelModel.cities;
    }
}

