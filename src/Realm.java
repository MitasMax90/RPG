import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Realm {

    private static BufferedReader br;
    private static FantasyCreature player = null;
    private static Battle battle = null;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        battle = new Battle();

        System.out.println("Назовите имя персонажа");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void command(String string) throws IOException {
        if (player == null) {
            player = new Hero(string, 100, 20, 20, 0, 0);


            System.out.println(String.format("Крушить врагов налево и направо будет %s! Пожелаем удачи!", player.getName()));

            printNavigation();
        }
        switch (string) {
            case "1": {
                System.out.println("Торговец спит");
            }
            break;
            case "2": {
                commitFight();
            }
            break;
            case "3":
                System.exit(1);
                break;
            case "да":
                command("2");
                break;
            case "нет": {
                printNavigation();
                command(br.readLine());
            }
        }
        command(br.readLine());
    }

    private static void commitFight() {
        battle.fight(player, createMonster(), new FightCallback() {

            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d очков опыта и %d единиц золота, так же %d единиц здоровья.", player.getName(), player.getExperience(), player.getGold(), player.getHealthPoint()));
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {

            }
        });
    }
    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }

    private static FantasyCreature createMonster() {

        int random = (int) (Math.random() * 10);

        if (random % 2 == 0) return new Goblin(
                "Гоблин",
                25,
                10,
                10,
                100,
                20
        );
        else return new Skeleton(
                "Скелет",
                25,
                20,
                20,
                100,
                10
        );
    }

    interface FightCallback {
        void fightWin();
        void fightLost();
    }

}
