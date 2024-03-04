package Warriors;

import Warriors.BaseWarrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spearman extends BaseWarrior{
    protected int arrows;
    public Spearman(String name, Place position) {
        super(name, position);
        this.armor = 3;
        this.health = 60;
        this.damage = 30;
        this.initiative = 3;
        int arrows = 20; // дал ему 20 стрел по дефолту, не знаю, где он должен их брать
    }

    @Override
    public void step(ArrayList<BaseWarrior> enemies) {
        if (this.health > 0 && this.arrows > 0){
            BaseWarrior target = this.findNear(enemies);
            this.attack(target);
            this.arrows--;
        }
        else return;
    }

    @Override
    public String getInfo() {
        return "Ведьмак";
    }
}
