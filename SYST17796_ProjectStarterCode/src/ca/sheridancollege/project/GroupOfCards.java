/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 might want to subclass this more than once. The group of cards has a maximum
 size attribute which is flexible for reuse.
 *
 * @author dancye
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList<>();
    private int size;//the size of the grouping

    public GroupOfCards(int givenSize) {
        size = givenSize;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> showCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }

    public void populate() {
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                cards.add(new CardOfWar(r.toString(), s.toString()));
            }
        }
    }

    public void deal(GroupOfCards pile1, GroupOfCards pile2) {
        Random rand = new Random();
        int counter = cards.size()/2;
        System.out.println("Counter is " + counter);
        for (int i = 0; i < counter; i++) {
            int randNum = rand.nextInt(cards.size());
            pile1.showCards().add(cards.get(randNum));
            cards.remove(randNum);
        }
        pile2.showCards().addAll(cards);
        System.out.println("Pile1 size is " + pile1.showCards().size());
        System.out.println("Pile2 size is " + pile2.showCards().size());
    }
    

}//end class
