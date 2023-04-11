package com.nyc.practice;

public class StaticMethodExample {
    int marks= 90;
    static int age= 25;

    public static void main(String args[]){

        StaticMethodExample sme= new StaticMethodExample();
        StaticMethodExample sme1= new StaticMethodExample();

        System.out.println("sme marks= " + sme.marks);
        System.out.println("sme1 marks= " + sme1.marks);

        System.out.println();

        sme1.marks=88;
        System.out.println("sme marks= " + sme.marks);
        System.out.println("sme1 marks= " + sme1.marks);
    }
}


