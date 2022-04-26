package com.revature.week3.Day9;

import java.util.LinkedList;

public class Exercise1 {
    public static void main(String[] args) {
        // created an empty LinkedList
        LinkedList<String>l_list = new LinkedList<String>();
        //use add () method to add values in the linked list
        l_list.add("red");
        l_list.add("Green");
        l_list.add("Black");
        l_list.add("White");
        l_list.add("Yellow");
        // print the list
        System.out.println("Original linked list: "+l_list);
        //Add an element at the end of a linked list
        l_list.offerLast("Pink");
        System.out.println("Final linked list");
    }
}
