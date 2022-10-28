package Status;

public class PlayerStatus {

    public static Object name = SetName.playerName.inputName;
    public static int level = 1;
    public static int power = 3;
    public static int hitpoints = 10;
    public static int maxhitpoints = 10;
    public static String pumpkin = "Not yet";
    public static String mummy = "Not yet";
    public static String dracula = "Not yet";

    public static void showStatus() {
        System.out.println("------------------------------");
        System.out.println(name + "\nLevel:" + level + "  Power:" + power + "  HP:" + hitpoints + "/" + maxhitpoints);
        System.out.println("------------------------------");
    }
    
    //Recoads of defeated ghosts to set clear condition
    public static void showDefeatGhosts() {
        System.out.println("------------------------------");
        System.out.println("Recoads\nPumpkin: " + pumpkin + "  Mummy: " + mummy + "  Dracula: " + dracula);
        System.out.println("------------------------------");
    }

}

