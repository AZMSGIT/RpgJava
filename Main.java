import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name, hero? ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            name = "Hero";
        }

        Player player = new Player(name, scanner);
        Enemy[] enemies = {
            new Enemy("Goblin", 50, 8),
            new Enemy("Ork", 70, 11),
            new Enemy("Dragon", 100, 14)
        };

        for (int i = 0; i < enemies.length; i++) {
            System.out.println("\n===== Fight " + (i + 1) + "/3: " + enemies[i].name + " =====");
            Battle battle = new Battle(player, enemies[i]);
            boolean win = battle.start();
            if (!win) {
                System.out.println("\n" + enemies[i].name + " Win. Game over.");
                return;
            }
            System.out.println("\n" + enemies[i].name + " Defeated!");
        }
        System.out.println("\nYou winned them all. Victory!");
    }
}
