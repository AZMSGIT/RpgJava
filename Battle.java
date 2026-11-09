// Один бой игрока с врагом
public class Battle {
    Player player;
    Enemy enemy;

    Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    // возвращает true, если игрок победил
    boolean start() {
        int round = 1;
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n--- Round " + round + " ---");
            player.showStatus();
            enemy.showStatus();
            System.out.println();

            player.makeTurn(enemy);
            if (!enemy.isAlive()) {
                break;
            }

            System.out.println();
            enemy.makeTurn(player);
            round++;
        }
        return player.isAlive();
    }
}
