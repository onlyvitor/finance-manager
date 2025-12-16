public class Main {

    public static void main(String[] args) {
        TransactionRepository repo = new TransactionRepository();
        FinanceService fService = new FinanceService(repo);

        System.out.println("Welcome to Finance Manneger!");

        fService.addIncome(1000, "vendas", "mercado");
        fService.addExpanse(100, "almoço", "mercado");

        System.out.println(fService.getBalance());
    }
}
