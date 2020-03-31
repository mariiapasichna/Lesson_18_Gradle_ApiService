package com.mariiapasichna.myApiService;

public class Users {
    int id;
    String name;
    String username;
    String email;
    Address address;
    String phone;
    String website;
    Company company;

    private class Address {
        String street;
        String suite;
        String city;
        String zipcode;
        Geo geo;

        private class Geo {
            String lat;
            String lng;

            @Override
            public String toString() {
                return "{" +
                        "lat='" + lat + '\'' +
                        ", lng='" + lng + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "{" +
                    "street='" + street + '\'' +
                    ", suite='" + suite + '\'' +
                    ", city='" + city + '\'' +
                    ", zipcode='" + zipcode + '\'' +
                    ", geo=" + geo +
                    '}';
        }
    }

    private class Company {
        String name;
        String catchPhrase;
        String bs;

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", catchPhrase='" + catchPhrase + '\'' +
                    ", bs='" + bs + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}