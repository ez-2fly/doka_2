package Warriors;

import Warriors.BaseWarrior;

import java.util.ArrayList;

public class Peasant extends BaseWarrior {

    public Peasant(String name, Place position) {
        super(name, position);
        this.armor = 2;
        this.health = 50;
        this.damage = 15;
        this.initiative = 0;
    }

    @Override
    public void step(ArrayList<BaseWarrior> allies) {
        for (BaseWarrior unit : allies){
            if (unit.getClass() == Crossbowman.class || unit.getClass() == Spearman.class) {
                ((Spearman) unit).arrows++;
            }
        }
    }

    @Override
    public String getInfo() {
        return "Peasant";
    }
}
