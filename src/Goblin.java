public class Goblin extends FantasyCreature implements Fighter {

    public Goblin(String name, int healthPoint, int strength, int dexterity, int gold, int experience) {
        super(name, healthPoint, strength, dexterity, gold, experience);
    }

    @Override
    public int attack() {
        return super.attack();
    }
}
