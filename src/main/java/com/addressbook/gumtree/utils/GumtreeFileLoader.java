package com.addressbook.gumtree.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GumtreeFileLoader {

    private File file;

    public GumtreeFileLoader(String filePath){
        try{
            file = new File(filePath);
        }  catch (NullPointerException npe) {
            throw new IllegalArgumentException("File path cannot be null.");
        }
    }

    public List<String> readFromFile() {
        List<String> lines;
        try{
            lines = FileUtils.readLines(file);
        }  catch (IOException ioe) {
            throw new IllegalArgumentException("File does not exist or corrupted");
        }
        return lines;
    }
}
