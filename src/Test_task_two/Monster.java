package Test_task_two;

public class Monster extends Being{

    public Monster(int attack, int defence, int health, int lim_health, int min_damage, int max_damage) {
        super(attack, defence, health, lim_health, min_damage, max_damage);
    }

    public void takeDamage(int damage) {
        if (damage > 0) {
            this.health -= damage;
            System.out.println("Монстр получил - " + damage + " урона");
        }
        else {
            System.out.println("Монстр не получил урона");
        }
    }
}
