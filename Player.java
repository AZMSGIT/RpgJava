import java.util.Scanner;

// Игрок: действие выбирается с клавиатуры
public class Player extends Fighter {
    Scanner scanner;

    Player(String name, Scanner scanner) {
        super(name, 100, 15);
        this.scanner = scanner;
    }

    @Override
    int chooseAction() {
        while (true) {
            System.out.println("Your turn: 1 - Hit, 2 - Defence, 3 - Heal, 4 - Risk");
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equals("1") || input.equals("2") || input.equals("4")) {
                return Integer.parseInt(input);
            } else if (input.equals("3")) {
                if (healsLeft > 0) {
                    return 3;
                }
                System.out.println("All heasl wasted!");
            } else {
                System.out.println("Enter number from 1 to 4.");
            }
        }
    }
}
