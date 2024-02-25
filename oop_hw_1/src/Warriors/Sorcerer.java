package Warriors;

import Warriors.BaseWarrior;

import java.util.ArrayList;

public class Sorcerer extends BaseWarrior {
    public Sorcerer(String name, Place position) {
        super(name, position);
        this.armor = 2;
        this.health = 70;
        this.damage = 25;
        this.initiative = 1;
    }

    @Override
    public String toString() {
        return this.getClass() + ": " + this.name;
    }

    @Override
    public void step(ArrayList<BaseWarrior> enemies) {

    }
}
