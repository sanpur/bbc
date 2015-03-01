package com.gumtree.addressbook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SimpleDataLoaderTest {

    private SimpleDataLoader simpleDataLoader;

    @Test
    public void testPopulateData() throws Exception {

        simpleDataLoader = new SimpleDataLoader();
        List<String> fileLines = new ArrayList<String>();

        fileLines.add("Sarah Stone, Female, 20/09/80");
        fileLines.add("Wes Jackson, Male, 14/08/74");

        Map<Integer, Person> personData = simpleDataLoader.populateData(fileLines);

        assertEquals(2, personData.size());

        Person p1 = personData.get(0);
        assertEquals("Sarah Stone", p1.getName());

        Person p2 = personData.get(1);
        assertEquals("Male", p2.getSex());

    }
}