import java.util.Random;

// Общий класс бойца
public class Fighter {
    String name;
    int maxHp;
    int hp;
    int damage;
    int healsLeft = 3;
    boolean defending = false;
    Random random = new Random();

    Fighter(String name, int maxHp, int damage) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.damage = damage;
    }

    // Выбор действия: 1 - бить, 2 - защита, 3 - лечиться, 4 - рискнуть
    // Игрок и враг переопределяют этот метод
    int chooseAction() {
        return 1;
    }

    boolean isAlive() {
        return hp > 0;
    }

    void showStatus() {
        System.out.println(name + ": HP " + hp + "/" + maxHp + ", Healing: " + healsLeft);
    }

    void takeDamage(int dmg) {
        if (defending) {
            dmg = dmg / 2;
            System.out.println(name + " Defenced and gets" + dmg + " damage.");
        } else {
            System.out.println(name + " gets " + dmg + " damage.");
        }
        hp = hp - dmg;
        if (hp < 0) {
            hp = 0;
        }
    }

    void attack(Fighter target) {
        // урон от 80% до 120% от базового
        int dmg = (int) Math.round(damage * (0.8 + random.nextDouble() * 0.4));
        System.out.println(name + " hit " + target.name + "!");
        target.takeDamage(dmg);
    }

    void defend() {
        defending = true;
        System.out.println(name + " defencing.");
    }

    void heal() {
        if (healsLeft <= 0) {
            System.out.println(name + " wanted to heal, but all heals wasted. Turn wasted.");
            return;
        }
        healsLeft--;
        int before = hp;
        hp = hp + 30;
        if (hp > maxHp) {
            hp = maxHp;
        }
        System.out.println(name + " Healing: +" + (hp - before) + " HP.");
    }

    void risk(Fighter target) {
        double k = 0.1 + random.nextDouble() * 2.9; // от 0.1 до 3.0
        int dmg = (int) Math.round(damage * k);
        System.out.println(name + " Risking! Damage coefficient: " + Math.round(k * 100) / 100.0);
        target.takeDamage(dmg);
    }

    // Выполнить ход
    void makeTurn(Fighter target) {
        defending = false; // защита длится только до следующего хода
        int action = chooseAction();
        if (action == 1) {
            attack(target);
        } else if (action == 2) {
            defend();
        } else if (action == 3) {
            heal();
        } else if (action == 4) {
            risk(target);
        }
    }
}
