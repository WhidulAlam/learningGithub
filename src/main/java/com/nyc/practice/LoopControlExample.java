package com.nyc.practice;

public class LoopControlExample {

    public void printNumbers(){

        System.out.println(10);
        System.out.println(11);
        System.out.println(12);
        System.out.println(13);
        System.out.println(14);
        System.out.println(15);
        System.out.println(16);
        System.out.println(17);
        System.out.println(18);
        System.out.println(19);
    }

    public void WhileLoop(){
        int x=21;

        while(x<20){
            System.out.println("Value of x: " + x);
            x++;
        }

    }

    public void ForLoop(){
        for(int x=10; x<20; x++){
            System.out.println("Value of x: " + x);
        }
    }

    public void DoWhileLoop(){
        int x=21;

        do{
            System.out.println("Value of x: " + x);
            x++;
        }while(x<20);
    }
}
