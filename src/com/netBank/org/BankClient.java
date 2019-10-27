package com.netBank.org;

import java.util.Scanner;

public class BankClient {
    private int current = -1;
    private Scanner scanner;
    private boolean done = false;
    private Bank bank = new Bank();

    public void processCommand(int cmd) {
        if (cmd == 0) quit();
        else if (cmd == 1) newAccount();
        else if (cmd == 2) select();
        else if (cmd == 3) deposit();
        else if (cmd == 4) authorizeLoan();
        else if (cmd == 5) showAll();
        else if (cmd == 6) addInterest();
        else
            System.out.println("Illegal command");
    }

    public void run(){
        scanner = new Scanner(System.in);
        while(!done){
            System.out.print("Enter Command (0 = quit, 1 = new, 2 = select, 3 = deposit, 4 = loan, 5 = show, 6 = interest) ");
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
    }

    private void quit(){
        done = true;
        System.out.println("Thank You");
    }

    private void select(){
        System.out.print("Enter Account#: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account " + current + "is " + balance);
    }


    private void newAccount(){
        current = bank.newAccount();
        System.out.println("Your new account number is" + current);
    }

    private void showAll(){
        System.out.println(bank.toString());
    }

    private void deposit(){
        System.out.print("Enter deposit amt: ");
        int amt = scanner.nextInt();
        bank.deposit(current, amt);
    }

    private void authorizeLoan(){
        System.out.print("Enter loan amt: ");
        int loanamt = scanner.nextInt();
        if(bank.authorizeLoan(current, loanamt))
            System.out.println("Loan is Approved");
        else
            System.out.println("Loan is denied");
    }

    private void addInterest(){
        bank.addInterest();
    }
}
