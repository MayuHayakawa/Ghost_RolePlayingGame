package Command;
import java.util.Scanner;

public class Search {

    public static void choosePlace() {
        Battle battle = new Battle();
        
        Scanner input = new Scanner(System.in);
        char option = '\0';

        do {
            System.out.println();
            System.out.println("Where do you wanna go?");
            System.out.println("========== SearchMenu ==========");
            System.out.println("1. Pumpkin Patch <Lv1>");
            System.out.println("2. Mummy Grave <Lv2>");
            System.out.println("3. Dracula's Castle <Lv3>");
            System.out.println("4. Return to MainMenu");
            System.out.println("===============================");
            System.out.print("Enter an option: ");
            option = input.next().charAt(0);

            switch(option) {
                case '1':
                    System.out.println();
                    battle.battleWithPumpkin();
                    break;
                case '2':
                    System.out.println();
                    battle.battleWithMummy();
                    break;
                case '3':
                    System.out.println();
                    battle.battleWithDracula();
                    break;
                case '4':
                    MainMenu.showMenu();
                    input.close();
                    break;
                default:
                    System.out.println();
                    System.out.println(">>Invalid option. Please enter again.");
                    break;
            }
        }while(option != '4');
    }
}
