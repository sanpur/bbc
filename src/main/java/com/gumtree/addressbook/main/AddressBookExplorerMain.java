package com.gumtree.addressbook.main;

import com.gumtree.addressbook.AddressBookExplorer;
import com.gumtree.addressbook.SimpleDataLoader;
import com.gumtree.addressbook.utils.DateUtil;
import com.gumtree.addressbook.utils.GumtreeFileLoader;

public class AddressBookExplorerMain {

    public static void main(String args[]){

        GumtreeFileLoader fileLoader = new GumtreeFileLoader("src/main/resources/AddressBook.txt");
        AddressBookExplorer addressBook = new AddressBookExplorer(fileLoader, new SimpleDataLoader());

        System.out.println("Number of males in the address book is : "+addressBook.getNumberOfMales());
        System.out.println("Oldest person in the address book is : "+addressBook.getTheOldestPerson());
        System.out.println("Number of days Bill older than Paul is : "+addressBook.getOlderByNumberOfDays(DateUtil.getDateFromString("16/03/77"), DateUtil.getDateFromString("15/01/85")));
    }
}
