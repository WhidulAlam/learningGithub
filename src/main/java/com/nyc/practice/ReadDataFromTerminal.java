package com.nyc.practice;

import java.util.Scanner;

public class ReadDataFromTerminal {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String s= in.nextLine();
        System.out.println("You entered string: "+s);


        System.out.println("Enter your age: ");
        int a= in.nextInt();
        System.out.println("You entered string: "+a);
    }
}
