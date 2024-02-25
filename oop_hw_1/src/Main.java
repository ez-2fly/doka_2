import Warriors.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<BaseWarrior> teamRadiant = pullTeam(true);
        ArrayList<BaseWarrior> teamDire = pullTeam(false);

        ArrayList<BaseWarrior> all = new ArrayList<>();
        all.addAll(teamRadiant); all.addAll(teamDire);

        all.sort(new Comparator<BaseWarrior>() {
            @Override
            public int compare(BaseWarrior o1, BaseWarrior o2) {
                return o2.getInitiative() - o1.getInitiative();
            }
        });

        all.forEach(n -> n.getInfo());
    }


    // Т.к. координаты у сторон разные, в метод передается булевый параметр выбора стороны,
    // условно, true - силы света, false - силы тьмы.
    public static ArrayList<BaseWarrior> pullTeam(boolean side){
        ArrayList<BaseWarrior> team = new ArrayList<>();
        Random randomHero = new Random();
        Place position = new Place(0,0);

        if (side){
            position.y = 9;
        }
        else {
            position.x = 9;
        }

        for (int i = 0; i < 9; i++) {
            switch (randomHero.nextInt(7)){
                case 0:
                    team.add(new Crossbowman(randomName(), position));
                    break;
                case 1:
                    team.add(new Monk(randomName(), position));
                    break;
                case 2:
                    team.add(new Peasant(randomName(), position));
                    break;
                case 3:
                    team.add(new Robber(randomName(), position));
                    break;
                case 4:
                    team.add(new Sniper(randomName(), position));
                    break;
                case 5:
                    team.add(new Sorcerer(randomName(), position));
                    break;
                case 6:
                    team.add(new Spearman(randomName(), position));
                    break;
            }
            if (side){
                position.x++;
                position.y--;
            }
            else {
                position.x--;
                position.y++;
            }
        }
        return team;
    }
    // Метод выбора случайного имени
    public static String randomName(){
        int random = new Random().nextInt(Names.values().length);
        return Names.values()[random].toString();
    }
}
