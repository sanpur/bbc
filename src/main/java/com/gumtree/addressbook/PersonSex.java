package com.gumtree.addressbook;

public enum PersonSex {

    MALE("Male"),
    FEMALE("Female");
    private final String givenName;

    PersonSex(String name){
        this.givenName = name;
    }

    public String getName(){
        return this.givenName;
    }
}
