package com.revature.week2.Assignment_day7;

public class Exercise1 {
    public static void main(String[] args) {
        int a = 40, b = 4, c = 4;
        int result;
        try {
            result = a / (b - c);
        } catch (ArithmeticException ex) {
            System.out.println("Cannot divide by zero. " + ex);
        } catch (Exception ex){
            System.out.println("Exception occur");
        }
        finally {
            System.out.println("Solved");
        }
    }

}