package com.gumtree.addressbook;

import com.gumtree.addressbook.utils.GumtreeFileLoader;
import java.util.*;

public class AddressBookExplorer {

    List<String> fileReadLines = new ArrayList<String>();
    Map<Integer, Person> personData = new HashMap<Integer, Person>();

    public AddressBookExplorer(GumtreeFileLoader gumtreeFileLoader, IDataLoader dataLoader) {
        fileReadLines = gumtreeFileLoader.readFromFile();
        personData = dataLoader.populateData(fileReadLines);

    }

    public int getNumberOfMales() {

        Set<Map.Entry<Integer, Person>> entries = personData.entrySet();
        int males = 0;
        for (Map.Entry<Integer, Person> entry : entries) {

            Integer key = entry.getKey();
            Person person = personData.get(key);
            if(person.getSex().equals(PersonSex.MALE.getName())){
                males++;
            }
        }
        return males;
    }

    public String getTheOldestPerson() {
        Set<Map.Entry<Integer, Person>> entries = personData.entrySet();
        Date oldest = new Date();
        Person oldPerson = null;
        for (Map.Entry<Integer, Person> entry : entries) {

            Integer key = entry.getKey();
            Person person = personData.get(key);
            if(person.getDOB().before(oldest)) {
                oldest = person.getDOB();
                oldPerson = person;
            }

        }
        return oldPerson.getName();
    }

    public int getOlderByNumberOfDays(Date dob1, Date dob2) {
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        cal1.setTime(dob1);
        cal2.setTime(dob2);
        int days = (int)( (cal1.getTimeInMillis() - cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24));
        return Math.abs(days);
    }
}
