package com.gumtree.addressbook;

import java.util.Date;

public class Person {

    private String name;
    private String sex;
    private Date DOB;

    public Person(String name, String sex, Date DOB){
        this.name = name;
        this.sex = sex;
        this.DOB = DOB;
    }

    public String getName() {
        return this.name;
    }

    public String getSex() {
        return this.sex;
    }

    public Date getDOB() {
        return this.DOB;
    }

}
