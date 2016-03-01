package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main  {
    static String [][] String ={{"String"}};
public static void main(String [] args){
Boolean b1 ,b2;

    System.out.print(1.0/0.0);

}

    public static int solution(int[] A){

        int count = 0;
        int f = A[0];
        for (int i = 0; i < A.length-1; i++) {
            if (A[i] != f) {
                for (int j = i; j< A.length;j++){
                    if (A[j]!=f) count++;
                }
            }
        }
        return count;
    }
}
