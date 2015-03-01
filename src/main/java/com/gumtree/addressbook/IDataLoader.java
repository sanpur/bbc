package com.gumtree.addressbook;

import java.util.List;
import java.util.Map;

public interface IDataLoader {

    public Map<Integer, Person> populateData(List<String> lines);
}
