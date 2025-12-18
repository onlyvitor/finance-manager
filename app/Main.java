import CLI.CliController;
import java.util.Scanner;
import repository.TransactionRepository;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionRepository repo = new TransactionRepository();
        CliController controller = new CliController(repo);

        System.out.println("Welcome to te fManager");
        System.out.println("Type 'help' for commands or 'exit' to quit.");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("bye.");
                break;
            }

            controller.handle(command);
        }

        scanner.close();
    }
}
