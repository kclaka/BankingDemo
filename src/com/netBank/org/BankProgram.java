package com.netBank.org;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BankProgram {

    private HashMap<Integer, Integer> accounts = new HashMap<>();

    private double rate = 0.01;
    private int nextacct = 0;
    private int current = -1;
    private Scanner scanner;
    private boolean done = false;


    public void run(){
        scanner = new Scanner(System.in);
        while(!done){
            System.out.print("Enter Command (0 = quit, 1 = new, 2 = select, 3 = deposit, 4 = loan, 5 = show, 6 = interest) ");
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
    }

    public void processCommand(int cmd){
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

    private void quit(){
        done = true;
        System.out.println("Thank You");
    }

    private void newAccount(){
        current = nextacct++;
        accounts.put(current, 0);
        System.out.println("Your new Account number is" + current);
    }

    private void select(){
        System.out.print("Enter Account#: ");
        current = scanner.nextInt();
        int balance = accounts.get(current);
        System.out.println("The balance of account " + current + "is " + balance);
    }

    private void deposit(){
        System.out.print("Enter deposit amount: ");
        int amt = scanner.nextInt();
        int balance = accounts.get(current);
        accounts.put(current, balance+amt);
    }

    private void authorizeLoan(){
        System.out.println("Enter Loan Amount: ");
        int loanamt = scanner.nextInt();
        int balance = accounts.get(current);
        if (balance >= loanamt/2)
            System.out.println("Your loan is approved");
        else
            System.out.println("Your Loan is denied");
    }

    private void showAll(){
        Set<Integer> accts = accounts.keySet();
        System.out.println("The bank has " + accts.size()
        + "accounts");

        for(int i : accts)
            System.out.println("\tBank account" + i
            + ": balance=" + accounts.get(i));
    }

    private void addInterest(){
        Set<Integer> accts = accounts.keySet();
        for(int i : accts){
            int balance = accounts.get(i);
            int newbalance = (int) (balance * (1 + rate));
            accounts.put(i, newbalance);
        }
    }

}
