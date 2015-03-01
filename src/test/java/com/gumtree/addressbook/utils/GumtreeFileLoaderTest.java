package com.gumtree.addressbook.utils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.containsString;;

public class GumtreeFileLoaderTest {

    GumtreeFileLoader gumtreeFileReader;


    @Test
    public void testNullSafely() {
        try {
            gumtreeFileReader = new GumtreeFileLoader(null);
        }catch(IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("File path cannot be null"));
        }

    }

    @Test
    public void testNonExistFileShouldReturn() {

        try{
            gumtreeFileReader = new GumtreeFileLoader("NON_EXIST_FILE");
            gumtreeFileReader.readFromFile();
        }catch (IllegalArgumentException iae) {
            assertThat(iae.getMessage(), containsString("File does not exist or corrupted"));
        }
    }

    @Test
    public void shouldReadFromValidAddressBook(){

        gumtreeFileReader = new GumtreeFileLoader("src/test/resources/AddressBook.txt");
        List lines = gumtreeFileReader.readFromFile();
        assertEquals(5, lines.size());
    }
}
