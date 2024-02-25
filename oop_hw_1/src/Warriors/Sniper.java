package Warriors;

import Warriors.BaseWarrior;

import java.util.ArrayList;
import java.util.Random;

public class Sniper extends BaseWarrior {
    public Sniper(String name, Place position) {
        super(name, position);
        this.armor = 3;
        this.damage = 40;
        this.health = 55;
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
