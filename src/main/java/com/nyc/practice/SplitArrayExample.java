package com.nyc.practice;

public class SplitArrayExample {

    public static void  main(String[]args){
        String sentence= "I Love NewYork";

        String[] words= sentence.split(" ");
        for(String word:words){
            System.out.print("Word is: " + word);
        }
        String reverse = "";

        for(int i = words.length -1; i >=0; i--){
            reverse += words[i] + " ";
        }

        System.out.print("Sentence is: " + reverse);
    }
}
