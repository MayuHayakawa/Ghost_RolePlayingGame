package Command;

import Status.PlayerStatus;

public class Heal {
    
    public static void heal() {
        PlayerStatus.hitpoints = PlayerStatus.maxhitpoints;
        System.out.println("------------------------------");
        System.out.println(PlayerStatus.name + " regained health!");
        PlayerStatus.showStatus();
        MainMenu.showMenu();
    }
}
