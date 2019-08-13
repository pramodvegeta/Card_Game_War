package ca.sheridancollege.project;

/**
 *
 * @author Pramod Chandra
 */
public class GameOfWar extends Game {

    GroupOfCards deck = new GroupOfCards(52);

    int roundNum = 0;
    int warNum = 0;

    PlayerOfWar p1;
    PlayerOfWar p2;

    public GameOfWar(String gameName) {
        super(gameName);
    }

    @Override
    public void play() {
        deck.populate();
        deck.shuffle();
        p1 = (PlayerOfWar) getPlayers().get(0);
        p2 = (PlayerOfWar) getPlayers().get(1);
        deck.deal(p1.getPile(), p2.getPile());
    }

    @Override
    public void declareWinner() {
        if (p1.getPile().showCards().isEmpty() || p1.getPile().showCards().size() < 3) {
            System.out.println("You have lost the game");
        } else {
            System.out.println("\nYou have won the game");
        }

    }

    public String oneRound() {
        p1.play();
        p2.play();
        roundNum++;
        return declareResult(p1.flipACard(0), p2.flipACard(0), false);
    }

    public String declareResult(Card c1, Card c2, boolean war) {
        String roundWinner = "";
        int result = ((CardOfWar) c1).compareTo((CardOfWar) c2);
        switch (result) {
            case -1:
                if (war) {
                    warNum = 0;
                    for (int i = 0; i < 3; i++) {
                        p2.getPile().showCards().add(p1.removeACard());
                        p2.getPile().showCards().add(p2.removeACard());
                    }
                } else {
                    p2.getPile().showCards().add(p1.removeACard());
                    p2.getPile().showCards().add(p2.removeACard());
                }
                roundWinner = "lost";
                break;
            case 0:
                roundWinner = "tie";
                if (p2.getPile().showCards().size() < 3) {
                    declareWinner();

                } else if (p1.getPile().showCards().size() < 3) {
                    declareWinner();

                } else {
                    warNum = warNum + 2;
                    war();
                }

                break;
            case 1:
                if (war) {
                    warNum = 0;
                    for (int i = 0; i < 3; i++) {
                        p1.getPile().showCards().add(p2.removeACard());
                        p1.getPile().showCards().add(p1.removeACard());
                    }
                } else {
                    p1.getPile().showCards().add(p2.removeACard());
                    p1.getPile().showCards().add(p1.removeACard());
                }
                roundWinner = "won";
                break;
        }
        return roundWinner;

    }

    public void war() {
        declareResult(p1.flipACard(warNum), p2.flipACard(warNum), true);
    }

    public int getWarNum() {
        return warNum;
    }

    public int getRoundNum() {
        return roundNum;
    }

    public boolean isWinner() {
        if (p1.getPile().showCards().size() <= 2 || p1.getPile().showCards().size() >= 50) {
            declareWinner();
            return false;
        } else {
            return true;
        }
    }

}
