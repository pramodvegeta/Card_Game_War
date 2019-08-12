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

    private int pileSize;

    public PlayerOfWar(String name) {
        super(name);
    }

    @Override
    public void setPlayerID(String playerID) {
        if (!playerID.isEmpty()) {
            if (playerID.matches("[a-z A-z_]+")) {
                super.setPlayerID(playerID);
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
        flipACard(0);
    }

    public Card flipACard(int index) {
        return pile.showCards().get(index);
    }

    public Card removeACard() {
        return pile.showCards().remove(0);
    }
}
