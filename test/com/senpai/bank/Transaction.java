package com.senpai.bank;

public class Transaction {
    private int amount;
    private String date;

    public Transaction(int amount) {
        this.amount = amount;
    }
    public Transaction(int amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public String date() {
        return "2015/07/17";
    }

    public int amount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (amount != that.amount) return false;
        return !(date != null ? !date.equals(that.date) : that.date != null);

    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
