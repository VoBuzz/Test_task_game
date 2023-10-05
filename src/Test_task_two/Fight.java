package Test_task_two;

import java.util.Random;
//Этот класс описывает взаимодействие (бой) между игроком и монстром.
public class Fight {
    private Player player;
    private Monster monster;

    public Fight(Player player, Monster monster) {
        setMonster(monster);
        setPlayer(player);
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    //Рассчет модификатора атаки
    public int mod_attack(int attack, int defence) {

        return (attack - defence + 1);
    }
    // Метод рассчета нанесения удара по имитации броска кубика. В любом случаи кубик бросается хотя бы один раз
    public int huk(int mod_attack, int damage) {
        Random rn = new Random();
        int randomNum = 0;
        if (mod_attack > 0) {
            for (int i = 0; i < mod_attack; i++) {

                randomNum = rn.nextInt(6 - 1 + 1) + 1; // Имитация броска кубика(1, 6)
                if (randomNum == 5 || randomNum == 6) {
                    return damage;
                }
            }
        }
        else  {
            randomNum = rn.nextInt(6 - 1 + 1) + 1; // Бросок кубика(1, 6)
            if (randomNum == 5 || randomNum == 6) {
                return damage;
            }
        }
        return 0;
    }
    public void fight() {
        int hiil_counter = 0;
        System.out.println("Драка началась ! ");
        while (player.getHealth() > 0 && monster.getHealth() > 0){ //Бой длится пока один из участников не погибнет
            System.out.println("Здоровье игрока - " + player.getHealth());
            System.out.println("Здоровье монстра - " + monster.getHealth());
            //Урон который наносят игрок и монстр за один удар.
            int player_give_damage = huk(mod_attack(player.getAttack(), monster.getDefence()), player.getDamage());
            int monster_give_damage = huk(mod_attack(monster.getAttack(), player.getDefence()), monster.getDamage());
            // обновление значений возможного урона для игрока и монстра.
            player.setDamage(player.getMin_damage(), player.getMax_damage());
            monster.setDamage(monster.getMin_damage(), monster.getMax_damage());
            //Первый удар наносит игрок
            monster.takeDamage(player_give_damage);
            if (monster.getHealth() > 0) {
                player.takeDamage(monster_give_damage);
                //Если здороье игрока падает до критического значения, то он автоматически лечиться(не больше 4 раз)
                if (player.getHealth() > 0 && player.getHealth() < 10 && hiil_counter < 4) {
                    player.hill(player.getHealth(), player.getMax_health());
                    hiil_counter++;
                }
            }
        }
        //Результаты боя
        if (player.getHealth() <= 0) {
            System.out.println(" Вы проиграли в битве.");
        } else {
            System.out.println(" Вы победили в битве.");
        }
    }

}
