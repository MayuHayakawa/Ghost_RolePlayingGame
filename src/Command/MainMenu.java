package Command;

import java.util.Scanner;

import Status.PlayerStatus;

public class MainMenu {
    
    public static void showMenu() {

        Scanner input = new Scanner(System.in);
        char option = '\0';
        
        do {
            System.out.println();
            System.out.println("========== MainMenu ==========");
            System.out.println("1. Search a ghosts");
            System.out.println("2. Take a break");
            System.out.println("3. Check your status");
            System.out.println("4. Give up");
            System.out.println("==============================");
            
            System.out.print("Enter an option: ");
            option = input.next().charAt(0);
            
            switch(option) {
                case '1':
                    Search.choosePlace();             
                    break;
                case '2':
                    System.out.println();
                    Heal.heal();
                    break;
                case '3':
                    System.out.println();
                    PlayerStatus.showStatus();
                    PlayerStatus.showDefeatGhosts();
                    break;
                case '4':
                    input.close();
                    break;
                default:
                    System.out.println();
                    System.out.println("------------------------------");
                    System.out.println("Invalid option. Please enter again.");
                    System.out.println("------------------------------");
                    break;
            }
        }while(option != '4');
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("We're waiting for your challenge again! :)");
        System.out.println("------------------------------");

    };
}
