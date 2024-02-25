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
    public String toString() {
        return this.getClass() + ": " + this.name;
    }

    private double getDistance(BaseWarrior target){
        Place a = this.position;
        Place b = target.position;
        int ab = ((b.x - a.x)^2 + (b.y - a.y)^2);
        return Math.sqrt((double)ab);
    }
    protected BaseWarrior findNear(List<BaseWarrior> enemies){
        double minDistance = this.getDistance(enemies.getFirst());
        BaseWarrior nearEnemy = enemies.getFirst();
        for (BaseWarrior enemy : enemies){
            if (this.getDistance(enemy) < minDistance) {
                minDistance = this.getDistance(enemy);
                nearEnemy = enemy;
            }
        }
        return nearEnemy;
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
}
