package com.nyc.practice;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    HashMap<String,String> hmp= new HashMap<>();

    public void addHashMapValue(){

        hmp.put("IE", "Internet Explorer");
        hmp.put("CB", "Chrome Browser");

       //System.out.println("Browser name of CB: "+ hmp.get("CB"));

        for(Map.Entry me:hmp.entrySet()){
            System.out.println("key="+me.getKey()+", Value="+me.getValue());
        }

        System.out.println();
        System.out.println("Size of the map:"+hmp.size());

        System.out.println();
        System.out.println("Contest of the map:"+ hmp);

        //System.out.println("Value for mm: "+ hmp.get("mm"));
    }
    public static void main(String args[]){

        HashMapExample hme= new HashMapExample();
        hme.addHashMapValue();
    }
}
