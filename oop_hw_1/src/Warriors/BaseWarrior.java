package Warriors;

import java.util.List;

abstract public class BaseWarrior implements Step{
    protected String name;
    protected int experience;
    protected int level;
    protected int health;
    protected int armor;
    protected int damage;
    protected Place position;
    protected int initiative;

    protected BaseWarrior(String name, Place position){
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.position = position;
    }

    // Если у воина есть единицы брони, то они теряются при атаке на него,
    // когда броня рушится, урон наносится непосредственно основной шкале здоровья.
    // За каждую атаку воин получает 10 единиц опыта.
    protected void attack(BaseWarrior target){
        if (target.armor > 0) target.armor--;
        else target.health-=this.damage;
        this.experience+=10;
    }

    // Воин условно лечится на 10% от своего настоящего запаса здоровья.
    protected void heal(){
        this.health += this.health/100*10;
    }

    // Не знаю, как реализовать автоматическое повышение уровня при достижении 100 единиц опыта,
    // поэтому сделал 2 метода для просмотра опыта и ручного повышения уровня при достижении порога.
    protected void getStats(){
        System.out.format("%s: experience - %d, level - %d", this.name, this.experience, this.level);
    }
    protected void levelUp(){
        if (this.experience >= 100) this.level++;
        else System.out.println("Not enough experience!");
    }
    public void getInfo(){
        System.out.format("%s: health - %d, armor - %d, damage - %d", this.name, this.health, this.armor, this.damage);
    }

    public int getInitiative(){
        return this.initiative;
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
}
