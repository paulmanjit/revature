package com.revature.week3.Day9;

import java.util.LinkedList;

public class Exercise2 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(40);
        linkedList.add(44);
        linkedList.add(40);
        linkedList.add(90);
        linkedList.add(3);
    }
    public static void
    iterateUsingForLoop(LinkedList<Integer>linkedList){
        System.out.println("Iterating the LikedList using a simple for loop: ");
        for (int i=0; i<linkedList.size(); i++){
            System.out.println(linkedList);
        }
    }
}
