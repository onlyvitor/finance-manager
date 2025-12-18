package model;

import java.time.LocalDate;

public class Transaction {

    private final int id;
    private final TransactionType type;
    private final double amount;
    private final String category;
    private final String description;
    private final LocalDate date;

    public Transaction(
        int id,
        TransactionType type,
        double amount,
        String category,
        String description,
        LocalDate date
    ) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }
}
