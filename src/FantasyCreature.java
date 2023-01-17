
public abstract class FantasyCreature implements Fighter {

    /*
    у всех персонажей должны быть такие характеристики:
    ИМЯ, ЛОВКОСТЬ, ОПЫТ, ЕДИНИЦЫ ЖИЗНИ, ЗОЛОТО, СИЛА
     */
    private String name;

    private int healthPoint; // Здоровье
    private int strength; // Сила
    private int dexterity; // Ловкость

    private int gold; // Золото
    private int experience; // Опыт

    // Конструктор
    public FantasyCreature(String name, int healthPoint, int strength, int dexterity, int gold, int experience) {
        this.name = name;
        this.healthPoint = 100;
        this.strength = 25;
        this.dexterity = 20;
        this.gold = gold;
        this.experience = experience;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    private int getRandomValue() {
        return (int)(Math.random() * 100);
    }

    private int getRandomValueForCritical() { return (int)(Math.random() * 5); }

    /*
    Кроме того, все персонажи должны уметь атаковать,
    иногда атака может быть неудачной (промах),
    успех атаки зависит от Ловкости персонажа.
    */
    public int attack() {
        if (dexterity * 3 > getRandomValue()) {
            if (getRandomValueForCritical() == 2) { // С вероятностью 0,2 сила удара увеличивается
                return strength * 2; // в 2 раза
            }
            return strength;
        } else return 0;

    }

    @Override
    public String toString() {
        return String.format("%s Здоровье:%d", name, healthPoint);
    }
}
