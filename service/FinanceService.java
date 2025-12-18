package service;

import java.time.LocalDate;
import model.Transaction;
import model.TransactionType;
import repository.TransactionRepository;

public class FinanceService {

    private TransactionRepository repository;
    private int Nextid = 1;

    public FinanceService(TransactionRepository repository) {
        this.repository = repository;
    }

    private void createTransaction(
        TransactionType type,
        double amount,
        String category,
        String description
    ) {
        Transaction transaction = new Transaction(
            Nextid++,
            type,
            amount,
            category,
            description,
            LocalDate.now()
        );
        repository.save(transaction);
    }

    private void validadeamount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("O valor inserido é invalido");
        }
    }

    public void addIncome(double amount, String category, String description) {
        validadeamount(amount);
        createTransaction(
            TransactionType.INCOME,
            amount,
            category,
            description
        );
    }

    public void addExpanse(double amount, String category, String description) {
        validadeamount(amount);
        createTransaction(
            TransactionType.EXPANSE,
            amount,
            category,
            description
        );
    }

    public double getBalance() {
        double balance = 0;

        for (Transaction t : repository.findAll()) {
            if (t.getType() == TransactionType.INCOME) {
                balance += t.getAmount();
            } else {
                balance -= t.getAmount();
            }
        }

        return balance;
    }
}
