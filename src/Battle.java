import javax.security.sasl.RealmCallback;

public class Battle {
    public void fight(FantasyCreature hero, FantasyCreature monster, Realm.FightCallback fightCallback) {
        Runnable runnable = () -> {
            int turn = 1;
            boolean isFightEnded = false;
            while (!isFightEnded) {
                System.out.println("----Ход: " + turn + "----");
                if (turn++ % 2 != 0) {
                    isFightEnded = makeHit(monster, hero, fightCallback);
                } else {
                    isFightEnded = makeHit(hero, monster, fightCallback);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Boolean makeHit(FantasyCreature defender, FantasyCreature attacker, Realm.FightCallback fightCallback) {
        int hit = attacker.attack();
        int defenderHealth = defender.getHealthPoint() - hit;
        if (hit != 0) {
            System.out.println(String.format("%s Нанёс удар в %d единиц", attacker.getName(), hit));
            System.out.println(String.format("У %s осталось %d единиц здоровья..", defender.getName(), defenderHealth));
        } else {
            System.out.println(String.format("%s промахнулся!", attacker.getName()));
        }
        if (defenderHealth <= 0 && defender instanceof Hero) {
            System.out.println("Вы пали в бою, мастер!");
            fightCallback.fightLost();
            return true;
        } else if (defenderHealth <= 0) {
            System.out.println(String.format("Враг побеждён! Вы получаете %d опыт и %d золота", defender.getExperience(), defender.getGold()));
            attacker.setHealthPoint(attacker.getHealthPoint() + defender.getHealthPoint());
            attacker.setGold(attacker.getGold() + defender.getGold());
            fightCallback.fightWin();
            return true;
        } else {
            defender.setHealthPoint(defenderHealth);
            return false;
        }
    }
}


