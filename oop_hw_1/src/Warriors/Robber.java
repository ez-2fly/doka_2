package Warriors;

import Warriors.BaseWarrior;

import java.lang.reflect.Array;
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
        if (this.health <= 0) return;
        BaseWarrior target = this.findNear(enemies);
        if (Math.abs(target.position.x - this.position.x) == 1 || Math.abs(target.position.y - this.position.y) == 1) this.attack(target);
        else movement(target);
    }

    private void movement(BaseWarrior target){
        int dx = this.position.x - target.position.x;
        int dy = this.position.y - target.position.y;
        if (dx > dy){
            if (dx < 0) this.position.x++;
            else this.position.x--;
        }
        else {
            if (dy < 0) this.position.y++;
            else this.position.y--;
        }
    }
}
