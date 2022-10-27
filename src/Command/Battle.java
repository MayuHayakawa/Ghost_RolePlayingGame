package Command;
import java.util.Scanner;

import Status.GhostStatus;
import Status.PlayerStatus;

// import trash.Status;
public class Battle {

    Scanner input = new Scanner(System.in);
    char option = '\0';

    Object name = PlayerStatus.name;
    String ghostnm = "";
    int ghostpw = 0;
    int ghosthp = 0;

    public void battleWith(String ghostname, int ghostlevel, int ghostpower, int ghosthitpoints) {

        ghostnm = ghostname;
        ghostpw = ghostpower;
        ghosthp = ghosthitpoints;

        System.out.println(ghostname + " appeared! \nWhat will you do?");
        System.out.println("------------------------------");
        
        do {
            do {
                do {
                    System.out.println();
                    System.out.println("========== BattleMenu ==========");
                    System.out.println("1. Fight");
                    System.out.println("2. Check my status");
                    System.out.println("3. Run");
                    System.out.println("================================");
                    
                    System.out.print("Enter an option: ");
                    option = input.next().charAt(0);
                    
                    switch(option) {
                        case '1':
                            System.out.println();
                            //プレイヤーのレベルが敵より高ければプレイヤーが先に攻撃できる
                            if(PlayerStatus.level > ghostlevel) {
                                dealDamage();
                                calculateDealDamage(ghosthp, PlayerStatus.power);
                                //敵の体力が残っている場合は敵が攻撃する
                                if(ghosthp > 0) {
                                    showGhostHP();
                                    getDamage();
                                    calculateGetDamage(PlayerStatus.hitpoints, ghostpower);
                                    if (PlayerStatus.hitpoints > 0) {
                                        showPlayerHP();
                                    }
                                }
                                //プレイヤーのレベルが敵以下だった場合は敵が先に攻撃する
                            } else {
                                getDamage();
                                calculateGetDamage(PlayerStatus.hitpoints, ghostpower);
                                //プレイヤーの体力が残っている場合はプレイヤーが攻撃する
                                if(PlayerStatus.hitpoints > 0) {
                                    showPlayerHP();
                                    dealDamage();
                                    calculateDealDamage(ghosthp, PlayerStatus.power);
                                    if(ghosthp > 0) {
                                        showGhostHP();
                                    }
                                }
                            }

                            if (PlayerStatus.hitpoints <= 0) {
                                System.out.println("------------------------------");
                                System.out.println(name + " got scared and ran away...");
                                Logo.gameover();
                                input.close();
                                System.exit(0);
                            }

                            if (ghosthp <= 0 ) {
                                updateBattleRecords();
                                if(PlayerStatus.pumpkin.equals("Done") && PlayerStatus.mummy.equals("Done") && PlayerStatus.dracula.equals("Done")) {     
                                    System.out.println(ghostnm + " has disappeared!\nAnd " + name + " has defeated ALL ghosts!!!");
                                    Logo.clear();
                                    input.close();
                                    System.exit(0);
                                } else {
                                    levelUp();
                                    MainMenu.showMenu();
                                }
                                input.close();
                            }
                            break;

                        case '2':
                                System.out.println();
                                PlayerStatus.showStatus();
                                break;

                        case '3':
                                System.out.println();
                                System.out.println("Got away safety!");
                                Search.choosePlace();
                                input.close();
                                break;

                        default:
                                System.out.println();
                                System.out.println(">>Invalid option. Please enter again.");
                                break;

                    }
                }while (PlayerStatus.hitpoints >= 0);
            } while (ghosthp >= 0);
        }while(option != 3);
    }   


    public void battleWithPumpkin() {
        GhostStatus ghost = new GhostStatus("Pumpkin", 1, 2, 10);
        System.out.println("------------------------------");
        ghost.showStatus();
        System.out.println();
        battleWith(ghost.name, ghost.level, ghost.power, ghost.hitpoints);
    };
    
    public void battleWithMummy() {
        GhostStatus ghost = new GhostStatus("Mummy", 2, 4, 15);
        System.out.println("------------------------------");
        ghost.showStatus();
        System.out.println();
        battleWith(ghost.name, ghost.level, ghost.power, ghost.hitpoints); 
    };
    
    public void battleWithDracula() {
        GhostStatus ghost = new GhostStatus("Dracula", 3, 6,30);
        System.out.println("------------------------------");
        ghost.showStatus();
        System.out.println();
        battleWith(ghost.name, ghost.level, ghost.power, ghost.hitpoints); 
    };


    public void getDamage() {
        System.out.println("------------------------------");
        System.out.println(ghostnm + " attacked " + name + "!\n" + name + "took " + ghostpw + " damage.");
    }

    public int calculateGetDamage(int hp, int power) {
        return PlayerStatus.hitpoints = hp - power;
    }

    public void dealDamage() {
        System.out.println("------------------------------");
        System.out.println(ghostnm + " attacked " + name + "!\n" + name + "took " + ghostpw + " damage.");
    }
    public int calculateDealDamage(int hp, int power) {
        return ghosthp = hp - power;
    }

    public void showPlayerHP() {
        System.out.println(name + "'s HP is " + PlayerStatus.hitpoints +  ".");
        System.out.println("------------------------------");
    }

    public void showGhostHP() {
        System.out.println("The ghost has " + ghosthp + " HP remaining.");
        System.out.println("------------------------------");
    }



    public void levelUp() {
        PlayerStatus.level++;
        PlayerStatus.power = PlayerStatus.power + 3;
        PlayerStatus.maxhitpoints = PlayerStatus.maxhitpoints + 5;
        System.out.println("------------------------------");
        System.out.println(ghostnm + " has disappeared!\n" + name + " grew to level " + PlayerStatus.level +"!");
        System.out.println();
        PlayerStatus.showStatus();
        System.out.println("------------------------------");

    };
    
    public void updateBattleRecords() {
        if(ghostnm.equals("Pumpkin")) {
            PlayerStatus.pumpkin = "Done";
        } else if (ghostnm.equals("Mummy")) {
            PlayerStatus.mummy = "Done";
        } else if (ghostnm.equals("Dracula")) {
            PlayerStatus.dracula = "Done";
        }
    }

}
