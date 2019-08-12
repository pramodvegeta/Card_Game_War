/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author Kiran
 */
public class PlayerOfWar extends Player {

    private GroupOfCards pile = new GroupOfCards(0);

    private String playerID;
    private int pileSize;

    public PlayerOfWar(String name) {
        super(name);
    }

    @Override
    public void setPlayerID(String playerID) {
        if (!playerID.isEmpty()) {
            if (playerID.matches("[a-zA-z_]+")) {
                this.playerID = playerID;
            }
        } else {
            throw new IllegalArgumentException(playerID + " is invalid name");
        }
    }

    public GroupOfCards getPile() {
        return pile;
    }

    public void setPile(GroupOfCards pile, int pileSize) {
        this.pileSize = pileSize;
        this.pile = pile;

    }

    @Override
    public void play() {
        System.out.println(pile.showCards().get(0));
        flipACard();
    }

    public Card flipACard() {
        return pile.showCards().get(0);
    }

    public Card flipACard(int x) {
        System.out.println("Next card hidden. Next next card is " + pile.showCards().get(x));
        return pile.showCards().get(x);
    }

//    public Card flipThirdCard() {
//        System.out.println("Second card hidden. Third card is " + pile.showCards().get(2));
//        return pile.showCards().get(2);
//    }

    public Card removeACard(int index) {
        return pile.showCards().remove(index);
    }
}
