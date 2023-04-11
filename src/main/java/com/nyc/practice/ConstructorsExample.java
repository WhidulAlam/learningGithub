package com.nyc.practice;


public class ConstructorsExample {
    int a =11;
    int b =21;
    int c =31;

    /*public ConstructorsExample(int objectA,int objectB,int objectC){
        a= objectA;
        b= objectB;
        c= objectC;}*/

        public ConstructorsExample( int a, int b, int c){
            this.a= a;
            this.b= b;
            this.c= c;
    }




    public static void main(String args[]){

      ConstructorsExample ce= new ConstructorsExample(11, 12,15);

        System.out.println("a= "+ce.a);
        System.out.println("b= "+ce.b);
        System.out.println("c= "+ce.c);

       ConstructorsExample ce1= new ConstructorsExample(101, 102, 103);

        System.out.println("ce1 a= "+ce1.a);
        System.out.println("ce1 b= "+ce1.b);
        System.out.println("ce1 c= "+ce1.c);

        ConstructorsExample ce2= new ConstructorsExample(201, 203, 204);

        System.out.println("ce2 a= "+ce2.a);
        System.out.println("ce2 b= "+ce2.b);
        System.out.println("ce2 c= "+ce2.c);

    }




}

