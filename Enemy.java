// Враг: действие выбирается случайно
public class Enemy extends Fighter {

    Enemy(String name, int maxHp, int damage) {
        super(name, maxHp, damage);
    }

    @Override
    int chooseAction() {
        // если здоровья мало и есть лечения - часто лечится
        if (healsLeft > 0 && hp < maxHp * 0.4 && random.nextInt(100) < 70) {
            return 3;
        }
        int r = random.nextInt(100);
        if (r < 55) {
            return 1; // бить
        } else if (r < 75) {
            return 2; // защита
        } else {
            return 4; // риск
        }
    }
}
