package com.zipcodewilmington.phonebook;

import java.lang.reflect.Array;
import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */

//Instructions:

//Building a basic PhoneBook class
//Create a PhoneBook class that holds names and phone numbers.

//You can use an associative data type (one which stores items as keys paired with values).

//Your PhoneBook class should have the following method
    //void add(String name, String phoneNumber)
    //adds an entry to the composite associate data type
    //void addAll(String name, String... phoneNumbers)
    //adds many phone numbers to a single name entry
    //void remove(String name)
    //removes an entry to the composite associate data type
    //Boolean hasEntry(String name)
    //removes an entry to the composite associate data type
    //List<String> lookup(String name)
    //returns a phone number for the respective input name
    //String reverseLookup(String phoneNumber)
    //returns a name for the respective input phoneNumber
    //String getAllContactNames()
    //returns a list of all names in this PhoneBook

public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = map!=null ? map : new LinkedHashMap<>();
    }

    public PhoneBook() {

        this(null);
    }

    public void add(String name, String phoneNumber) {
        if (!phonebook.containsKey(name)) {
            phonebook.put(name, new ArrayList<>());
        }
        phonebook.get(name).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        if (!phonebook.containsKey(name)) {
            phonebook.put(name, new ArrayList<>());
        }
        Collections.addAll(phonebook.get(name), phoneNumbers);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.getOrDefault(name, new ArrayList<>());
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if(entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}



