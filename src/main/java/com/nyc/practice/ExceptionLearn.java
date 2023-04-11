package com.nyc.practice;

public class ExceptionLearn {

    public static void summation() {
        int[] num = {1, 2,3,4};
        int result = num[0] + num[1];
        System.out.println("summation:" + result);
    }

    public static void multiplication() {
        int[] num = {1, 2, 3, 4};
        int result = num[3] + num[2];
        System.out.println("summation:" + result);
    }
    public static void main(String args[]) {

        ExceptionLearn el= new ExceptionLearn();
        ExceptionLearn.summation();
        ExceptionLearn.multiplication();

    }
}
