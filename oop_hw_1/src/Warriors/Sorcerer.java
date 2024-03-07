package Warriors;

import Warriors.BaseWarrior;

import java.util.ArrayList;
import java.util.Random;

public class Sorcerer extends BaseWarrior {
    protected int mana;
    public Sorcerer(String name, Place position) {
        super(name, position);
        this.armor = 2;
        this.health = 70;
        this.damage = 25;
        this.initiative = 1;
        this.mana = 10;
    }

    @Override
    public void step(ArrayList<BaseWarrior> allies) {
        ArrayList<BaseWarrior> deadAlliesList = new ArrayList<>();
        for (BaseWarrior unit : allies){
            if (unit.health <= 0) deadAlliesList.add(unit);
        }
        if (deadAlliesList.size() >= 3 && this.mana >= 10){
            Random r = new Random();
            deadAlliesList.get(r.nextInt(deadAlliesList.size())).health = 100;
            this.mana -= 10;
        }
        if (this.mana >= 2){
            Random r = new Random();
            allies.get(r.nextInt(allies.size())).health += 10;
            this.mana -= 2;
        }
        else this.mana++;
    }

    @Override
    public String getInfo() {
        return "Witcher";
    }
}
