package home.work;

public class SplitArryExample {

    public static void  main(String args[]){
        String sentence= "The quick brown fox";

       String[] words= sentence.split("");
        for(String i:words){
            System.out.print("Word is: " + i);
        }
        String reverse = "";

        for(int i = words.length -1; i >=0; i--){
            reverse += words[i] + " ";
        }

        System.out.print("Sentence is: " + reverse);
    }
}