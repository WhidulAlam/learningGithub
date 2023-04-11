package com.nyc.practice;

public class StringExample {

    public void indexOf(){
        String myStr = "Hello planet earth, you are a great planet.";
        System.out.println(myStr.indexOf("earth"));
    }

    public void Substring(){
        String str= "JavaPoint";
        String subStr= str.substring(0, 4);
        System.out.println(subStr);
    }

    public void length(){
        String txt= "Hello planet earth, you are a great planet";
        System.out.println(txt.length());
    }

    public void replace(){
        String myStr=  "Hello planet earth, you are a great planet";
        System.out.println(myStr.replace('o', 'a'));
    }

    public void Trim(){
        String myStr= "     Hello World!    ";
       // System.out.println(myStr);
        System.out.println(myStr.trim());
    }

    public void contains(){
        String myStr= "Hello";
        System.out.println(myStr.contains("Hell"));
    }

    public void format(){

        String name= "Jonathan";
        int age= 20;
        int salary= 4000;
        String s= String.format("My name is %s and I am %d years old and my salary is $%d yearly",name, age, salary);

        System.out.println(s);
    }

    public void charAt(){
         String myStr= "Hello";
         char result= myStr.charAt(4);
         System.out.println(result);
    }
}
