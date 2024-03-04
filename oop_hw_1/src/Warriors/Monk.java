package Warriors;

import Warriors.BaseWarrior;

public class Monk extends Sorcerer {
    public Monk(String name, Place position) {
        super(name, position);
    }

    @Override
    public String getInfo() {
        return "Монах";
    }
}
