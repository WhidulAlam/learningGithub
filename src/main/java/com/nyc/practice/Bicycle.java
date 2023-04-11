package com.nyc.practice;

public class Bicycle {

    public int gear=22;
    public int speed;

    public Bicycle(int gear, int speed){
        this.gear= gear;
        this.speed= speed;
    }
    public void applyBreak(int decrement){
        speed -= decrement;
    }
    public void speedup(int increment){
        speed += increment;
    }
    public String toString(){
        return("No of gears are " + gear + ", speed is " + speed);
    }

}

