package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Employee Dao
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while (flag) {
            System.out.println("********************************");
            System.out.println("Select from the options below");
            System.out.println("********************************");
            System.out.println("PRESS 1: Add Employee");
            System.out.println("PRESS 2: Update Employee");
            System.out.println("PRESS 3: Delete Employee");
            System.out.println("PRESS 4: Get All Employee");
            System.out.println("PRESS 5: Get Employee By ID");
            System.out.println("PRESS 6: Exit");
            System.out.println("********************************");

            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    // add;
                    System.out.print("Enter Id: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter email");
                    String email = scanner.next();
                    break;
                }
                case 2: {
                    // Update
                    System.out.print("Enter Id: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter email");
                    String email = scanner.next();
                    Employee employee = new Employee(id, name, email);
                    dao.updateEmployee(employee);
                    break;
                }
                case 3:{
                    System.out.print("Enter Id: ");
                    int id = scanner.nextInt();
                    dao.deleteEmployee(id);
                    break;
                }
                case 4: {
                    // get all
                    List<Employee> employees =  dao.getEmployees();
                    for(Employee employee: employees){
                        System.out.println(employee);
                    }
                    break;
                }
                case 5: {
                    // get employee by id
                    System.out.print("insert the employee id: ");
                    int id = scanner.nextInt();
                    dao.getEmployeeById(scanner.nextInt());
                    break;
                }
                case 6: {
                    // exit
                    System.out.println("Thank you");
                    System.out.println("Exiting...");
                    flag = false;
                    break;
                }
                default:
                    System.out.println("Choose between 1-6");
            }
        }
    }

}

