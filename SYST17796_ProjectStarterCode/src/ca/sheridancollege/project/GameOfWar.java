package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Pramod Chandra
 */
public class GameOfWar extends Game {

    GroupOfCards deck = new GroupOfCards(52);

    int roundNum = 0;
    boolean war = false;
    int warNum = 0;

    PlayerOfWar p1;
    PlayerOfWar p2;
//    PlayerOfWar tie;

    public GameOfWar(String gameName) {
        super(gameName);
    }

    @Override
    public void play() {
        deck.populate();
        deck.shuffle();
        p1 = (PlayerOfWar) getPlayers().get(0);
        p2 = (PlayerOfWar) getPlayers().get(1);

//        tie = (PlayerOfWar) getPlayers().get(2);
//        GroupOfCards pile3 = new GroupOfCards(52);

        deck.deal(p1.getPile(), p2.getPile());
    }

    @Override
    public void declareWinner() {
        System.out.print("winner is: ");
        if (p1.getPile().showCards().isEmpty() || p1.getPile().showCards().size() < 3) {
            System.out.println(p2.getPlayerID());
        } else {
            System.out.println(p1.getPlayerID());
        }

    }

    public String oneRound() {
        System.out.println("Round number: " + roundNum);
        System.out.println("Pile 1 is " + p1.getPile().showCards().size());
        System.out.println("Pile 2 is " + p2.getPile().showCards().size());
        p1.play();

        p2.play();
        roundNum++;
        return declareResult(p1.flipACard(), p2.flipACard(), false);
    }

    public String declareResult(Card c1, Card c2, boolean war) {
        String roundWinner = "";
        int c = 0;
        int result = ((CardOfWar) c1).compareTo((CardOfWar) c2);
        switch (result) {
            case -1:
                warNum = 0;
                if (war) {
                    for (int i = 0; i < 3; i++) {
                        p2.getPile().showCards().add(p1.removeACard(0));
                        p2.getPile().showCards().add(p2.removeACard(0));

                        System.out.println("-1 War if " + c);
                    }
                    //p2.getPile().showCards().add(p2.removeACard(0));
                    System.out.println("-1 if c is: " + c);
                } else {
                    p2.getPile().showCards().add(p1.removeACard(0));
                    p2.getPile().showCards().add(p2.removeACard(0));
                    System.out.println("-1 else c is: " + c);
                }
                System.out.println("-1 c is: " + c);
                roundWinner = "lost";
                break;
            case 0:
                roundWinner = "tie";
                if (p2.getPile().showCards().size() < 3) {
                    System.out.println("0 if c is: " + c);
                    isWinner(); //I added

                } else if (p1.getPile().showCards().size() < 3) {
                    System.out.println("0 else if c is: " + c);
                    isWinner(); //I added

                } else {
                    System.out.println("0 else c is: " + c);
                    warNum = warNum + 2;
                    war();
                }
                break;
            case 1:
                warNum = 0;
                if (war) {
                    for (int i = 0; i < 3; i++) {
                        p1.getPile().showCards().add(p2.removeACard(0));
                        p1.getPile().showCards().add(p1.removeACard(0));
                        System.out.println("1 if c is: " + c);
                    }
                } else {
                    p1.getPile().showCards().add(p2.removeACard(0));
                    p1.getPile().showCards().add(p1.removeACard(0));
                    System.out.println("1 else c is: " + c);
                }
                System.out.println("1 c is: " + c);
                roundWinner = "won";
                break;
        }
        return roundWinner;

    }

    public void war() {
        declareResult(p1.flipACard(warNum), p2.flipACard(warNum), true);
    }

    public boolean isWinner() {
        if (p1.getPile().showCards().size() <= 2 || p1.getPile().showCards().size() >= 50 || p2.getPile().showCards().size() >= 50 || p2.getPile().showCards().size() <= 2) {
            declareWinner();
            return false;
        } else {
            return true;
        }
    }

}
