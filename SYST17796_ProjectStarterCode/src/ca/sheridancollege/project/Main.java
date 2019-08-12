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

        System.out.printf("%s, do you want to start? \nEnter 'Yes' to start:\n", playerName);
        String decision = sc.nextLine();

        if (decision.equalsIgnoreCase("Yes")) {

            gow.getPlayers().add(p1);
            gow.getPlayers().add(p2);

            gow.play();

            while (gow.isWinner()) {
//                System.out.println(gow.oneRound());
                String roundResult = gow.oneRound();
                System.out.println("Round: " + gow.getRoundNum());
                System.out.println(p1.getPlayerID() + " currently has " + p1.getPile().showCards().size() + " cards");
                System.out.println(p2.getPlayerID() + " currently has " + p2.getPile().showCards().size() + " cards");

                if (roundResult.equalsIgnoreCase("tie")) {
//                    System.out.println(gow.getWarNum());
                    System.out.println("Previous cards flipped are hidden. Next next card is " + p1.flipACard(gow.getWarNum()).toString());
                } else {

                    System.out.println("For Player 1: " + p1.flipACard(gow.getWarNum()).toString()); //test
                    System.out.println("For Player 2: " + p2.flipACard(gow.getWarNum()).toString()); //test
                }
                System.out.println("You have " + roundResult + " this round.");
            }

        }
        System.out.println("You have decided to exit. \nGood Bye.");
    }
}
