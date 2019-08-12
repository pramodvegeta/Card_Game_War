package ca.sheridancollege.project;

/**
 *
 * @author judda
 */
public class Main {

    public static void main(String[] args) {
        GameOfWar gow = new GameOfWar("War");
        PlayerOfWar p1 = new PlayerOfWar("name");
        PlayerOfWar p2 = new PlayerOfWar("Computer");
//        PlayerOfWar tie = new PlayerOfWar("tie");
        gow.getPlayers().add(p1);
        gow.getPlayers().add(p2);
//        gow.getPlayers().add(tie);
        gow.play();
        while (gow.isWinner()) {
            System.out.println(gow.oneRound());
        }

    }
}
