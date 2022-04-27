package com.revature.week2.Assignment_day7;

/*NullPointerException
Throwable-> Exception ->RuntimeException -> NullPointerException
 */
class Student{
    public static Student student;

    public void Display(){
        System.out.println("Displaying .......");
    }
}
public class Exercise6 {
    public static void main(String[] args) {
        String Str = "Raju Ram";
        System.out.println(Str.length());
    String Str2 = null;
    try {
        System.out.println(Str.length());
    }catch (NullPointerException ex){
    }
    Student.student = new Student();
    Student.student.Display();
    }
}

