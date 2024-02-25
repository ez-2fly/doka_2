package Warriors;

import Warriors.BaseWarrior;

import java.util.ArrayList;

public class Robber extends BaseWarrior {
    public Robber(String name, Place position) {
        super(name, position);
        this.armor = 5;
        this.damage = 30;
        this.health = 70;
        this.initiative = 2;
    }

    @Override
    public String toString() {
        return this.getClass() + ": " + this.name;
    }

    @Override
    public void step(ArrayList<BaseWarrior> enemies) {

    }
}
