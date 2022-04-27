package com.revature.week2.Assignment_day7;

public class Exercise2_MultipleCatchBlock {
    public static void main(String[] args) {
        try {
            int a [] = new int[5];
            a[5] = 30/0;
        }
        catch (ArithmeticException e){
            System.out.println("ArithmeticException Occurs");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        }

        catch (Exception e){
            System.out.println("Parent Exception Occurs");
        }
        System.out.println("rest of the Code");

    }
}
