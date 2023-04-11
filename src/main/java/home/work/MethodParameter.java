
package home.work;

import com.nyc.practice.MethodParameterExamples;
public class MethodParameter {
    public int AddNumbers(int a, int b){

        int sum = a % b;

        return sum;
    }

    public static void main(String args[]){

        MethodParameter mpObject = new MethodParameter();
        int numbers = mpObject.AddNumbers(125,24);
        System.out.println(numbers);

    }

}