package com.revature.week2.Assignment_day7;
class YoungerAgeException extends RuntimeException {
    YoungerAgeException(String msg) {
        super(msg);
    }
}
    class A_Excercise5 {
        public static void main(String[] args) {
            int age = 16;
            if (age < 18) {
                throw new YoungerAgeException("-----");
            } else {

            }
        }

    }


