package com.revature.week2.Assignment_day7;

public class Exercise3_Throw {
void method1() throws ArithmeticException{
    throw new ArithmeticException("Calculation error");
}
void method2() throws ArithmeticException{
    method1();
}
void method3(){
    try {
        method2();
    }
    catch (ArithmeticException e){
        System.out.println("ArithmeticException handled");
    }
}

    public static void main(String[] args) {
        Exercise3_Throw obj = new Exercise3_Throw();
        obj .method3();
        System.out.println("End of Program");
    }
}
