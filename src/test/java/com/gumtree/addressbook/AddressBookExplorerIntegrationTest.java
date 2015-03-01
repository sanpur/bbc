package com.gumtree.addressbook;

import com.gumtree.addressbook.utils.GumtreeFileLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.gumtree.addressbook.utils.DateUtil;
public class AddressBookExplorerIntegrationTest {


    private AddressBookExplorer addressBookExplorer;
    private String addressBookFileName;
    private GumtreeFileLoader gumtreeFileLoader;
    private IDataLoader dataLoader;

    @Before
    public void setUp() {
        addressBookFileName = "src/test/resources/AddressBook.txt";
        gumtreeFileLoader = new GumtreeFileLoader(addressBookFileName);
        dataLoader = new SimpleDataLoader();
        addressBookExplorer = new AddressBookExplorer(gumtreeFileLoader, dataLoader);
    }


    @Test
    public void shouldGetNumberOfMales() {

        assertEquals(3, addressBookExplorer.getNumberOfMales());
    }


    @Test
    public void shouldGetTheOldestPersonInTheBook() {

        assertEquals("Wes Jackson", addressBookExplorer.getTheOldestPerson());
    }

    @Test
    public void shouldGetTheNumberOfDaysOlderDifference() {

        assertEquals(2862, addressBookExplorer.getOlderByNumberOfDays(DateUtil.getDateFromString("16/03/77"), DateUtil.getDateFromString("15/01/85")));
    }
}