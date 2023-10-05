package Test_task_two;


public class Main {
    public  static void main(String[] args){
        Player player = new Player(6, 30,  70, 100, 1, 6);
        System.out.println("Пример реализации битвы игрока и тролля.");
        Monster troll = new Monster(10, 25, 90, 100, 1, 4);
        Fight fight_to_troll = new Fight(player,troll);
        fight_to_troll.fight();

        System.out.println("#######################");
        System.out.println("#######################");
        System.out.println("#######################");

        System.out.println("Пример реализации битвы игрока и скелета.");
        Monster skeleton = new Monster(5, 10, 25, 100, 1, 3);
        Fight fight_to_skeleton = new Fight(player, skeleton);
        fight_to_skeleton.fight();

        System.out.println("#######################");
        System.out.println("#######################");
        System.out.println("#######################");

        System.out.println("Пример реализации битвы игрока и дракона.");
        Monster dragon = new Monster(30, 29, 100, 1000, 2, 10);
        Fight fight_to_dragon = new Fight(player, dragon);
        fight_to_dragon.fight();

    }

}