package com.senpai.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {

    public static final String TRANSACTIONS_HEADER = "TRANSACTION | AMOUNT | BALANCE";
    int balance = 0;
    private Console console;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(Console console) {
        this.console = console;
    }

    public int balance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
        transactions.add(new Transaction(amount, "2015/07/17"));
    }

    public void withdraw(int amount) {
        balance -= amount;
        transactions.add(new Transaction(-amount, "2015/07/17"));
    }

    public void printStatement() {
        console.printLine(TRANSACTIONS_HEADER);
    }

    public Transaction transaction() {
        return transactions.get(transactions.size()-1);
    }

    public List<Transaction> transactions() {
        return transactions;
    }
}
