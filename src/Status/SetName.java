package Status;
import java.util.Scanner;

//set public class to use inputName(value of inputName method that SetName's instance playerName) on other class
public class SetName {
    public static Scanner input;
    public static InputName playerName;

    public static void intro() {

        SetName.input = new Scanner(System.in);
        SetName.playerName = new InputName();

        //bellow method execution
        SetName.playerName.inputName(input);
    }
}

//input player name and say hi method
class InputName {
    public String inputName;

    public void inputName(Scanner input) {
        System.out.println("Please enter your name.");
        this.inputName = input.nextLine();
        System.out.println();
        System.out.println("Hello " + inputName + "!");
        System.out.println("Some ghosts have been playing tricks on everyone lately.\nCan you stop them?");
    }
}