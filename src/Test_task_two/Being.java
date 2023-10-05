package Test_task_two;

import java.util.Random;


public abstract class Being {

    private int attack;
    private int defence;
    protected int health;
    private int damage;
    private int max_damage;
    private int min_damage;

    public Being(int attack, int defence, int health, int lim_health, int min_damage, int max_damage) {
        setAttack(attack);
        setDefence(defence);
        setHealth(health, lim_health);
        setDamage(min_damage, max_damage);
        setMin_damage(min_damage);
        setMax_damage(max_damage);
    }

    public void setAttack(int attack){
        if (attack > 0 && attack < 32) {
            this.attack = attack;
        }
        else {
            System.out.println("Значение атаки для одного из обьестов вне заданного диапазона(1-31)");
            System.exit(0);
        }
    }

    public void setDefence(int defence) {
        if (defence > 0 && defence < 32) {
            this.defence = defence;
        }
        else {
            System.out.println("Значение обороны для одного из обьектов вне заданного диапазона(1-31)");
            System.exit(0);
        }
    }

    public void setHealth(int health, int lim_health) {
        if (health >= 0 && health < lim_health){
            this.health = health;
        }
        else {
            System.out.println("Значение для здоровья одного из обьектов превышают заданный лимит здороья для этого обьекта");
            System.exit(0);
        }
    }
    public void setMin_damage(int min_damage) {
        this.min_damage = min_damage;
    }
    public void setMax_damage(int max_damage) {
        this.max_damage = max_damage;
    }

    public int getMin_damage() {
        return this.min_damage;
    }

    public int getMax_damage() {
        return max_damage;
    }

    public void setDamage(int min_damage, int max_damage) {
        if (min_damage > 0 && (max_damage > 0 && max_damage > min_damage)){
            Random rn = new Random();
            this.damage = rn.nextInt(max_damage - min_damage + 1) + min_damage;
        }
        else {
            System.out.println("Ошибка в заданных значения максимального и минимального возможного дамага для одного из классов");
            System.exit(0);
        }
    }
    public int getAttack() {
        return this.attack;
    }

    public int getDefence() {
        return this.defence;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

}


