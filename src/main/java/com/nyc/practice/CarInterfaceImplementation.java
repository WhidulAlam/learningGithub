package com.nyc.practice;

public class CarInterfaceImplementation implements CarInterface{
    public  void setDoors(){
        System.out.println("Number of Doors= 4");
    }
    public  void setEngine(){
        System.out.println("Engine is Set!!");
    }
    public  void showMpg(){
        System.out.println("Mpg= 32");
    }
}
