package com.nyc.practice;

public class MountainBike extends Bicycle{

    public int seatHeight;

    public MountainBike(int gear, int speed, int seatHeight){
        super(gear,speed);


       /* this.gear= gear;
        this.speed= speed;*/
        this.seatHeight= seatHeight;
    }
    public void seatHeight(int newValue){
        seatHeight= newValue;
    }
    public String toString(){
        return("No of gears are " + gear + ", speed is " +  speed + ", Seat Height is " + seatHeight);
    }
}
