package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Nabeel
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String playerName = sc.nextLine(); // reads in name

        GameOfWar gow = new GameOfWar("War");
        PlayerOfWar p1 = new PlayerOfWar(playerName); // Player one created - which is the user
        PlayerOfWar p2 = new PlayerOfWar("Computer"); // Player two created - which is the computer

        System.out.printf("Greetings %s, do you want to start? \nEnter 'Yes' to start:\n", playerName);
        String decision = sc.nextLine();

        if (decision.equalsIgnoreCase("Yes")) {

            gow.getPlayers().add(p1);
            gow.getPlayers().add(p2);

            gow.play();

            while (gow.isWinner()) {
                String roundResult = gow.oneRound();
                System.out.println("\nRound: " + gow.getRoundNum());
                System.out.println(p1.getPlayerID() + " has " + p1.getPile().showCards().size() + " cards");
                System.out.println(p2.getPlayerID() + " has " + p2.getPile().showCards().size() + " cards");

                if (roundResult.equalsIgnoreCase("tie")) {
                    System.out.println("Next card is hidden. And the subsequent card is " + p1.flipACard(gow.getWarNum()).toString());
                } else {
                    System.out.println("Card on hand for Player 1: " + p1.flipACard(0).toString()); 
                    System.out.println("Card on hand for Player 2: " + p2.flipACard(0).toString()); 
                }
                System.out.println("You have " + roundResult + " this round.");
            }
        }
        else
        System.out.println("You have decided to exit. \nGood Bye.");
    }
}
