package Warriors;

import Warriors.BaseWarrior;

import java.util.ArrayList;
import java.util.Random;

public class Sniper extends Robber {
    public Sniper(String name, Place position) {
        super(name, position);
        this.armor = 3;
        this.damage = 40;
        this.health = 55;
        this.initiative = 2;
    }
}
