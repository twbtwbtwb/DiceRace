import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean wantsToPlay = true;
        System.out.println("Welcome to the Dice Race!");
        System.out.println("What is your name? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int players = getPlayers(scanner, name);
        System.out.println("Okay we will start the game with " + players + " players!\n");
        System.out.println("Good Luck!");
        while (wantsToPlay) {
            DiceRace diceRace = new DiceRace(players, name);
            wantsToPlay = diceRace.playGame();
        }
        System.out.println("Thanks for playing!");
    }

    public static int getPlayers(Scanner scanner, String name) {
        boolean validInput = false;
        int retVal = 0;
        while (!validInput) {
            System.out.println(name + ", how many players would you like to play against? (between 1 and 10)");
            if (scanner.hasNextInt()) {
                retVal = scanner.nextInt();
                validInput = true;
            }
            else {
                System.out.println("Invalid input. Must be a number between 1 and 10. Please try again\n");
                scanner.next();
            }
        }
        return retVal + 1;
    }
}
