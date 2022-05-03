package com.revature.week3.day12;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Assignment_day12 {
    public static class Exercise1 {
        public static void main(String[] args) {
            File file = new File("db");
            String[] List = file.list();
            for (String s : List) {

                System.out.println(s);
            }
            System.out.println("Get a list of file");
        }
    }

    public static class Exercise2 {

        public static void main(String[] args) {
            File dir = new File("db");
            dir.mkdir();
            File file = new File("db", "second.txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static class Exercise3 {
            public static void main(String[] args) {
                // create a file object
                try {
                    File file = new File("db", "/Users/manjitpaul/IdeaProjects/java_demo1/db/second.txt");

                    file.createNewFile();
                    System.out.println(file.exists());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public static class Exercise4 {
            public static void main(String[] args) {
                // create a file object
                try {
                    File file = new File("db", "/Users/manjitpaul/IdeaProjects/java_demo1/db/second.txt");

                    file.createNewFile();
                    System.out.println(file.exists());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        public static class Exercise5 {
            public static void main(String[] args) {
                String str;
                char ch[];
                Console obj = System.console();
                System.out.println("this is my first line to read");
                System.out.println("this is my middle line to read");
                System.out.println("this is my last line to read");
                str = obj.readLine();

            }
        }

        public static class Exercise6 {
            public static void main(String[] args) {
                File myFile = new File("manjit.txt");
                try {
                    Scanner sc = new Scanner(myFile);
                    while (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        System.out.println(line);
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

