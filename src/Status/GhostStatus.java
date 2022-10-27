package Status;

public class GhostStatus {

    public String name;
    public int level;
    public int power;
    public int hitpoints;

    public GhostStatus(String name, int level, int power, int hitpoints) {
        this.name = name;
        this.level = level;
        this.power = power;
        this.hitpoints = hitpoints;
    }

    public void showStatus() {
        System.out.println(this.name + "\nLevel:" + this.level + "  Power:" + this.power + "  HP:" + this.hitpoints);
    }

}
