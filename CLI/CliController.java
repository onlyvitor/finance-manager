package CLI;

import model.Transaction;
import repository.TransactionRepository;
import service.FinanceService;

public class CliController {

    private final TransactionRepository repo;
    private final FinanceService fService;

    public CliController(TransactionRepository repo) {
        this.repo = repo;
        this.fService = new FinanceService(repo);
    }

    public void handle(String input) {
        String[] parts = input.trim().split("\\s+", 5);

        if (parts.length == 0 || parts[0].isEmpty()) {
            return;
        }

        switch (parts[0]) {
            case "add":
                handleAdd(parts);
                break;
            case "balance":
                System.out.println(fService.getBalance());
                break;
            case "help":
                System.out.println(
                    """
                    command list:
                      add income|expanse amount category description
                      balance
                      history
                    """
                );
                break;
            case "history":
                printHistory();
                break;
            default:
                System.out.println("Error: invalid command, type 'help'");
        }
    }

    private void handleAdd(String[] parts) {
        if (parts.length < 5) {
            System.out.println(
                "Uso: add income/expanse amount category description"
            );
            return;
        }

        String type = parts[1];

        switch (type) {
            case "income":
                newIncome(parts);
                break;
            case "expanse":
                newExpanse(parts);
        }
    }

    private void newIncome(String[] parts) {
        double amount;
        try {
            amount = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            System.out.println(
                "invalid value: the second argument must be a number"
            );
            return;
        }
        String category = parts[3];
        String description = parts[4];
        fService.addIncome(amount, category, description);
    }

    private void newExpanse(String[] parts) {
        double amount;
        try {
            amount = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            System.out.println(
                "invalid value: the second argument must be a number"
            );
            return;
        }
        String category = parts[3];
        String description = parts[4];
        fService.addExpanse(amount, category, description);
    }

    private void printHistory() {
        for (Transaction t : fService.getHistory()) {
            System.out.println(
                "[" +
                    t.getDate() +
                    " | " +
                    t.getType() +
                    " | " +
                    t.getAmount() +
                    " | " +
                    t.getCategory() +
                    " | " +
                    t.getDescription() +
                    "]"
            );
        }
    }
}
