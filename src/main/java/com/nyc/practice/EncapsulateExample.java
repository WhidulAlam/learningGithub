package com.nyc.practice;

public class EncapsulateExample {
    private String Name;
    private int Roll;
    private int Age;

    //Getter method
    public String getName(){
        return Name;
    }
    public int getAge(){
        return Age;
    }
    public int getRoll(){
        return Roll;
    }
    //Setter method
    public void setName(String newName){
        Name= newName;
    }
    public void setRoll(int newRoll){
        Roll= newRoll;
    }
    public void setAge(int newAge){
        Age= newAge;
    }
    public static void main(String args[]){

        EncapsulateExample ee= new EncapsulateExample();
        ee.setName("Riiyad");
        ee.setRoll(5);
        ee.setAge(32);

        System.out.println("Name= "+ ee.getName());
        System.out.println("Roll= "+ ee.getRoll());
        System.out.println("Age= "+ ee.getAge());
    }
}
