package com.nyc.practice;

public abstract class Car {
    double mpg=44;
    int numOfDoors=4;
    String bodyType;

    public void showMpg(){
        System.out.println("MPG=" + mpg);
    }
    public void shownumOfDoors(){
        System.out.println("numOfDoors=" + numOfDoors);
    }
    public abstract void useElectricity();
}
