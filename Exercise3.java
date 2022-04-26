package com.revature.week3.Day9;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        ArrayList<String> Array = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Array.add ("30");
        Array.add ("24");
        Array.add ("60");
        Array.add ("89");
        Array.add ("70");
        //Array List
        System.out.println("List: "+Array);
        int start= scanner.nextInt();
        for (int i = start; i<Array.size(); i++){
            System.out.println("the element: "+Array.get(i));
        }
    }
}

