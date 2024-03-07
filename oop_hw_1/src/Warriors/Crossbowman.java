package Warriors;

public class Crossbowman extends Spearman {
    public Crossbowman(String name, Place position) {
        super(name, position);
        this.armor = 2;
        this.health = 55;
        this.damage = 35;
    }

    @Override
    public String getInfo() {
        return "Crossbowman";
    }
}
