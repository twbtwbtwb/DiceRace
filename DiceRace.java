import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DiceRace {
    private int players;
    private String username;
    private ArrayList<Player> allPlayers;
    private boolean winner;

    public DiceRace(int players, String username) {
        this.players = players;
        this.username = username;
        allPlayers = new ArrayList<>();
        winner = false;
    }

    public boolean playGame() {
        makePlayers();
        boolean finished = false;
        int turnNumber = 1;
        while (!finished) {
            finished = takeATurn(turnNumber);
            turnNumber++;
        }
        printWinner();
        return playAgain();
    }

    private void makePlayers() {
        for (int i = 1; i < players + 1; i++) {
            String playerName = "Player " + i;
            if (i == 1) {
                playerName = username;
            }
            allPlayers.add(new Player(playerName));
        }
    }

    private boolean takeATurn(int turnNumber) {
        for (int i = 0; i < allPlayers.size(); i++) {
            Player temp = allPlayers.get(i);
            System.out.println();
            System.out.println(temp.getPlayerName() + " Turn " + turnNumber);
            if (i == 0) {
                boolean readyToRoll = readyToRollDie();
            }
            int roll = rollDie();
            System.out.println(temp.getPlayerName() + " rolled a " + roll);
            temp.setPosition(temp.getPosition() + roll);
            System.out.println(temp.getPlayerName() + " is now at space " + temp.getPosition());
            printBoard();
            if (temp.getPosition() == 30) {
                return true;
            }
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void printBoard() {
        for (int i = 0; i < allPlayers.size(); i++) {
            Player temp = allPlayers.get(i);
            System.out.println(temp.toString());
        }
    }

    private boolean readyToRollDie() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        String temp = null;
        while (!validInput) {
            System.out.println("Press 'r' to roll the die");
            temp = scanner.next();
            if (temp.equals("r")) {
                validInput = true;
            }
            else {
                System.out.println("Invalid input. Press 'r' to roll the die\n");
            }
        }
        return validInput;
    }

    private int rollDie() {
        Random rand = new Random();
        int random = rand.nextInt(6);
        return random + 1;
    }

    public void printWinner() {
        if (allPlayers.get(0).getPosition() == 30) {
            System.out.println("Congratulations " + allPlayers.get(0).getPlayerName() + ", you win!");
        }
        else {
            for (int i = 1; i < allPlayers.size(); i++) {
                if (allPlayers.get(i).getPosition() == 30) {
                    System.out.println("Sorry " + allPlayers.get(0).getPlayerName() + ", "
                            + allPlayers.get(i).getPlayerName() + " won");
                }
            }
        }
    }

    private boolean playAgain() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        String temp = null;
        System.out.println("\nWould you like to play again? (y/n)");
        while (!validInput) {
            temp = scanner.next();
            if (temp.equals("y") || temp.equals("n")) {
                validInput = true;
            }
            else {
                System.out.println("Invalid input. Would you like to play again? (y/n)");
            }
        }
        return temp.equals("y");
    }
}
