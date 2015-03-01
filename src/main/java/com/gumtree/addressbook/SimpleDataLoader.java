package com.gumtree.addressbook;

import com.gumtree.addressbook.utils.DateUtil;
import java.util.*;

public class SimpleDataLoader implements IDataLoader {

    @Override
    public Map<Integer, Person> populateData(List<String> lines) {

        Map<Integer, Person> personMap = new HashMap<Integer, Person>();

        int count = 0;
        for (String line : lines) {

            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            Person person;
            String[] data = new String[3];
            int i = 0;
            while(tokenizer.hasMoreTokens()) {
                data[i] = tokenizer.nextToken().trim();
                i++;
            }
            person = new Person(data[0], data[1], DateUtil.getDateFromString(data[2]));
            personMap.put(count++, person);
        }

        return personMap;
    }
}
