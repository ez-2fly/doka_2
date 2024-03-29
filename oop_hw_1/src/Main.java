import Warriors.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<BaseWarrior> holyTeam = new ArrayList<>();
    public static ArrayList<BaseWarrior> darkTeam = new ArrayList<>();
    public static ArrayList<BaseWarrior> allTeam = new ArrayList<>();

    public static void main(String[] args) {
        holyTeam = pullTeam(true);
        darkTeam = pullTeam(false);

        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);

        allTeam.sort(new Comparator<BaseWarrior>() {
            @Override
            public int compare(BaseWarrior o1, BaseWarrior o2) {
                return o2.getInitiative() - o1.getInitiative();
            }
        });

        allTeam.forEach(BaseWarrior::getInfo);

        Scanner scan = new Scanner(System.in);
        while (true) {

            View.view();

            scan.nextLine();
            int hpSum = 0;
            int hpSum2 = 0;
            for (BaseWarrior unit : holyTeam){
                hpSum += unit.getHealth();
            }
            for (BaseWarrior unit : darkTeam){
                hpSum2 += unit.getHealth();
            }
            if (hpSum == 0) {
                System.out.println("Holy Team win!");
                break;
            }
            if (hpSum2 == 0) {
                System.out.println("Dark Team win!");
                break;
            }
            for (BaseWarrior unit : allTeam) {
                if (holyTeam.contains(unit)) unit.step(darkTeam);
                else unit.step(holyTeam);
            }
        }
    }


    // Т.к. координаты у сторон разные, в метод передается булевый параметр выбора стороны,
    // условно, true - силы света, false - силы тьмы.
    public static ArrayList<BaseWarrior> pullTeam(boolean side) {
        ArrayList<BaseWarrior> team = new ArrayList<>();
        Random randomHero = new Random();
        Place position = new Place(1, 1);

        if (side) {
            position.y = 10;
        } else {
            position.x = 10;
        }

        for (int i = 0; i < 11 ; i++) {
            switch (randomHero.nextInt(7)) {
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
            if (side) {
                position.x++;
                position.y--;
            } else {
                position.x--;
                position.y++;
            }
        }
        return team;
    }

    // Метод выбора случайного имени
    public static String randomName() {
        int random = new Random().nextInt(Names.values().length);
        return Names.values()[random].toString();
    }
}
