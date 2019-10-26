package com.netBank.org;

import java.util.HashMap;
import java.util.Scanner;

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
            System.out.print("Enter Command (0 = quit, 1 = new, 2 = select, 3 = deposit, 4 = loan, 4 = show, 6 = interest) ");
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
}
