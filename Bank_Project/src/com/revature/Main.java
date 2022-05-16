package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {


    public static class Bank_Project { //everything for scanner and console
        String name, email, password, account, transferAccount;
        int withdrawalamt, creditamt, bal, balance1, newBal, newBal2;
        int transferAmount;
        int ball = 0;
        Scanner sc = new Scanner(System.in);

        Bank_Project()
        {
            System.out.println("Welcome to Bank : ");
            System.out.println("Select a Module : ");
            System.out.println("1. User");
            System.out.println("2. Employee");
            System.out.println("3. Customer");
            String option = sc.next();

            switch (option) {
                case "1":
                    user();
                    break;
                case "2":
                    employee();
                    break;
                case "3":
                    customerlogin();
                    break;
                default:
                    System.out.println("Choose a valid option.");
                    break;
            }
        }
        public void user() {
            System.out.println("Hello User, please register to continue : ");
            System.out.println("Press '1' to register and 'E' to exit : ");
            String option = sc.next();
            if (option.equalsIgnoreCase("1")) {
                register();
            } else {
                System.out.println("Thanks for using Bank Services.");
                System.exit(0);
            }

        }

        public void employee() {
            System.out.println("Hello Employee!");
            System.out.println("What do you want to do ? ");
            System.out.println("1. See All Bank Accounts.");
            System.out.println("2. Transactions");
            String option = sc.next();
            switch (option) {
                case "1":
                    allBankAccounts();
                    break;
                case "2":
                    transactions();
                    break;
                default:
                    System.out.println("Please choose a valid option.");
                    break;
            }
        }

        public void allBankAccounts() {
            String allaccs = null, names = null;
            try {
             //   Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "root", "Priyapal12_");
                PreparedStatement ps = con.prepareStatement("select * from register");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    allaccs = rs.getString("accno");
                    names = rs.getString("Name");
                    System.out.println(names + " : " + allaccs);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public void transactions() {
            System.out.println("Can be Implemented using Files.");
        }

        public void customerlogin() {
            System.out.println("Enter Your Account Number : ");
            account = sc.next();

            System.out.println("Enter Your Password : ");
            String pin = sc.next();
            String name = null, accno2 = null, pass = null, email = null, balance = null, module = null;
            try {
             //   Class.forName("com.mysql.jdbc.Driver"); //why this formula is not for all method
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "root", "Priyapal12_");
                PreparedStatement ps = con.prepareStatement("select * from register where accno='" + account + "' ");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    name = rs.getString("Name");
                    email = rs.getString("email");
                    accno2 = rs.getString("accno");
                    pass = rs.getString("password");
                    balance1 = Integer.parseInt(rs.getString("balance"));
                    module = rs.getString("Module");

                    if (account.equals(accno2) && pin.equals(pass)) {
                        bankings();
                    } else {
                        System.out.println("Account Number or Password Mismatch !");
                    }

                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }

        public void bankings() {
            System.out.println("What Operation Do you want To Perform ?");
            System.out.println("1. Balance Check");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Logout");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    balCheck();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 5:
                    logout();
                    break;
                case 4:
                    transferAmount();
                    break;
                default:
                    System.out.println("Not a valid Option!");
                    break;
            }
        }

        public void balCheck() {
            System.out.println("Your Current Balance is : " + balance1);
            bankings();
        }

        void newBal() {
            newBal = ball + transferAmount;

            int i = 0;

            try {
             //   Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "root", "Priyapal12_");
                PreparedStatement ps = con.prepareStatement("update register set balance=? where accno=?");

                ps.setString(1, String.valueOf(newBal));
                ps.setString(2, transferAccount);

                i = ps.executeUpdate();

                if (i == 1) {
                    System.out.println("Amount Transferred Succesfully!");
                } else {
                    System.out.println("Error!");
                }

            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

        void newBal2() {
            newBal2 = balance1 - transferAmount;

            int i = 0;

            try {
               // Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "root", "Priyapal12_");
                PreparedStatement ps = con.prepareStatement("update register set balance=? where accno=?");

                ps.setString(1, String.valueOf(newBal2));
                ps.setString(2, account);

                i = ps.executeUpdate();

                if (i == 1) {
                    System.out.println("Amount Transferred Succesfully!");
                } else {
                    System.out.println("Error!");
                }

            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

        public void transferAmount() {
            System.out.println("Transfer Portal");
            System.out.println("Enter an account number in which you want to transfer amount : ");
            transferAccount = sc.next();
            System.out.println("Enter Amount to transfer : ");
            transferAmount = sc.nextInt();
            System.out.println("Do you want to transfer the amnount ? ");
            String consent = sc.next();
            System.out.println(account);
            System.out.println(transferAccount);
            System.out.println(bal);
            if (consent.equalsIgnoreCase("yes")) {
                String accno2 = null, aacc = null;

                try {
                   // Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "root", "Priyapal12_");
                    PreparedStatement ps = con.prepareStatement("select * from register where accno='" + transferAccount + "' ");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {

                        accno2 = rs.getString("accno");

                        ball = Integer.parseInt(rs.getString("balance"));
                        System.out.println("Hello");

                    }
                    newBal();
                    newBal2();
                } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
        }
        public void logout() {
            System.out.println("Thanks for using bank services.");
            System.exit(0);
        }
        public void register() {
            System.out.println("Register Portal");
            System.out.println("Enter Your Name : ");
            name = sc.next();
            System.out.println("Enter Email : ");
            email = sc.next();
            System.out.println("Enter Password : ");
            password = sc.next();
            System.out.println("Enter Balance : ");
            bal = sc.nextInt();


            System.out.println("Account Number : " + accNoGenerate());

            //insert into Register
            try {
              //  Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication?useUnicode=true&characterEncoding=utf8&verifyServerCertificate=false&useSSL=true&requireSSL", "root", "Priyapal12_");

                PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?,?)");
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, account);
                ps.setString(4, password);
                ps.setString(5, String.valueOf(bal));
                ps.setString(6, "Customer");

                int i = ps.executeUpdate();
                if (i == 1) {
                    System.out.println("You are Successfully Registered.");
                    System.out.println("Your Account Number is : " + account);
                } else {
                    System.out.println("Some error occured!");
                }


            } catch (Exception e) {
                System.out.println(e);
            }

        }

        public String accNoGenerate() {
            int accno = 1;

            try {
             //   Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankappliction", "root", "Priyapal12_");
                PreparedStatement ps = con.prepareStatement("select * from register");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    accno += 1;
                }
                account = "55120100" + accno + "";
                System.out.println("Your account number is :  " + account);
            } catch (Exception e) {
                System.out.println(e);
            }
            return account;
        }

        public void withdrawMoney() {
            System.out.println("Enter the Amount you want to withdraw : ");
            withdrawalamt = sc.nextInt();

            if (withdrawalamt > balance1) {
                System.out.println("Withdraw Amount More Than The current Balance ! Try Again !");
                withdrawMoney();
            } else {
                balance1 = balance1 - withdrawalamt;

                try {
                    int i = 0;
                  //  Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "root", "Priyapal12_");
                    PreparedStatement ps = con.prepareStatement("update register set balance=? where accno=?");
                    System.out.println(account);
                    System.out.println(balance1);

                    ps.setString(1, String.valueOf(balance1));
                    ps.setString(2, account);

                    i = ps.executeUpdate();
                    System.out.println(i + "");

                    if (i == 1) {
                        System.out.println("Succesfully withdrawed " + " Rs. " + withdrawalamt);
                        bankings();
                    } else {
                        System.out.println("Some error occured !");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }

        public void depositMoney() {
            System.out.println("Enter the money you want to deposit :");
            creditamt = sc.nextInt();
            if (creditamt < 500) {
                System.out.println("Minimum deposit amount is Rs.500 ! Enter valid amount");
                depositMoney();
            } else {
                balance1 = balance1 + creditamt;

                try {
                    int i = 0;
                   // Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "root", "Priyapal12_");
                    PreparedStatement ps = con.prepareStatement("update register set balance=? where accno=?");
                    System.out.println(account);
                    System.out.println(balance1);

                    ps.setString(1, String.valueOf(balance1));
                    ps.setString(2, account);

                    i = ps.executeUpdate();
                    System.out.println(i + "");

                    if (i == 1) {
                        System.out.println("Successfully Deposited " + " Rs. " + creditamt);
                        bankings();
                    } else {
                        System.out.println("Some error occurred !");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        public static void main(String[] args) {

            Bank_Project b = new Bank_Project();
        }
    }
}


