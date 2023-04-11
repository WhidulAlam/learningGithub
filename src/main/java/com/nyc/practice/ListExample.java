package com.nyc.practice;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

    List<String> lists= new ArrayList<String>();

    public void addValueToList(){
        lists.add("One");
        lists.add("Two");
        lists.add("Three");
    }

    public void readValueFromTheList(){
        System.out.println(lists);

        for(int i= 0; i < lists.size(); i++){
            System.out.println("Print value using Loop: " + lists.get(i));

        }
    }
}
