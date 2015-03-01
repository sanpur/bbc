package com.gumtree.addressbook;

import com.gumtree.addressbook.utils.DateUtil;
import com.gumtree.addressbook.utils.GumtreeFileLoader;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookExplorerTest {

    private AddressBookExplorer addressBookExplorer;
    private GumtreeFileLoader gumtreeFileLoader = mock(GumtreeFileLoader.class);
    private IDataLoader dataLoader = mock(IDataLoader.class);
    Person p1;
    Person p2;

    @Before
    public void setUp() {
        List<String> fileLines = new ArrayList<String>();

        String line1 = "Bill McKnight, Male, 16/03/77";
        String line2 = "Gemma Lane, Female, 20/11/91";
        String line3 = "Matt, Male, 20/12/94";

        fileLines.add(line1);
        fileLines.add(line2);
        fileLines.add(line3);

        Map<Integer, Person> personMap = new HashMap<Integer, Person>();

        p1 = new Person("Bill McKnight", "Male", DateUtil.getDateFromString("20/03/77"));
        p2 = new Person("Gemma Lane", "Female", DateUtil.getDateFromString("16/03/77"));
        Person p3 = new Person("Matt", "Male", DateUtil.getDateFromString("20/12/94"));

        personMap.put(1, p1);
        personMap.put(2, p2);
        personMap.put(3, p3);

        when(gumtreeFileLoader.readFromFile()).thenReturn(fileLines);
        when(dataLoader.populateData(fileLines)).thenReturn(personMap);
        addressBookExplorer = new AddressBookExplorer(gumtreeFileLoader, dataLoader);
    }



    @Test
    public void shouldGetNumberOfMales() {

        assertEquals(2, addressBookExplorer.getNumberOfMales());
    }


    @Test
    public void shouldGetTheOldestPersonInTheBook() {

        assertEquals("Gemma Lane", addressBookExplorer.getTheOldestPerson());
    }

    @Test
    public void shouldGetTheNumberOfDaysOlderDifference() {

        assertEquals(4, addressBookExplorer.getOlderByNumberOfDays(p2.getDOB(), p1.getDOB()));
    }
}
