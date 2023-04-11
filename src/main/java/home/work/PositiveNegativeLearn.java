package home.work;

import java.util.Scanner;
public class PositiveNegativeLearn {

    public static void main(String args[]){

        Scanner sc= new Scanner(System.in);
        System.out.println("Input any Number:");
        int n= sc.nextInt();

        if(n<0){
           //System.out.println("Number is positive");
            System.out.println("Number is  negative");
        }
    }
}
