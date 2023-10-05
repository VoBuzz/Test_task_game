package Test_task_two;

public class Player extends  Being {
    public Player(int attack, int defence, int health, int lim_health, int min_damage, int max_damage) {
        super(attack, defence, health, lim_health, min_damage, max_damage);
        setMax_health(health);
    }
    private int max_health;

    public void takeDamage(int damage) {
        if (damage > 0) {
            this.health -= damage;
            System.out.println("Игрок получил - " + damage + " урона");
        }
        else {
            System.out.println("Игрок не получил урона");
        }
    }
    public void  setMax_health(int max_health) {
        this.max_health = max_health;
    }

    public int getMax_health() {
        return max_health;
    }

    //метод лечения игрока. Количество востановляемого Xp зависит от начьного здоровья
    public void hill(int current_health, int max_health) {
        double relative_health = (max_health/100.0) * 30;
        if (current_health + relative_health <= max_health) {
            this.health +=  relative_health;
            System.out.println("Игрок исцелил себя на - " + relative_health + " xp");
        }
        else if (current_health + relative_health > max_health) {
            this.health +=  (max_health - relative_health);
            System.out.println("Игрок исцелил себя на - " + (max_health - relative_health)+ " xp");

        }

    }
}
