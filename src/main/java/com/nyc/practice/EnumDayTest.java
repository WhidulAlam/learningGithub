package com.nyc.practice;

public class EnumDayTest {

    EnumDay day;

    public EnumDayTest (EnumDay day){
        this.day=day;
    }
    public void dayIsLike(){

        switch(day){
            case MONDAY:
                System.out.println("Mondays are busy");
                break;
            case FRIDAY:
                System.out.println("Fridays are best");
                break;
            case SATURDAY:
                System.out.println("Saturdays are good");
                break;
            case SUNDAY:
                System.out.println("sundays are so-so");
                break;
        }
    }
    public static void main(String args[]) {
        String str= "FRIDAY";
        EnumDayTest ede= new EnumDayTest(EnumDay.valueOf(str));
        ede.dayIsLike();
    }
}
