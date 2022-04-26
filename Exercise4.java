package com.revature.week3.Day9;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Exercise4{
    public static void main(String[] args) {
        ArrayList<String> Count = new ArrayList<>();
        Count.add ("Six");
        Count.add ("Seven");
        Count.add ("Eight");
        Count.add ("Nine");
        Count.add ("Ten");
        System.out.println("Enter the Index number");
        Scanner scanner = new Scanner(System.in);
        int a;
        a = scanner.nextInt();
        for (int i=a; i<Count.size()-1;i++){
            System.out.println(Count);
        }
    }
}