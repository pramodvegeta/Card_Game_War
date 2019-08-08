package ca.sheridancollege.project;

/**
 *
 * @author judda
 */
public class CardOfWar extends Card {

    Rank rank;
    Suit suit;

    public CardOfWar(String rank, String suit) {
        boolean isRank = true;
        boolean isSuit = true;
        for (Rank r : Rank.values()) {
            if (r.getRankName().equalsIgnoreCase(rank)) {
                this.rank = r;
                isRank = false;
            }
        }
        if (isRank) {
            throw new IllegalArgumentException("The rank must in the range from 1-13");
        }

        for (Suit s : Suit.values()) {
            if (s.getSuitName().equalsIgnoreCase(suit)) {
                this.suit = s;
                isSuit = false;
            }
        }
        if (isSuit) {
            throw new IllegalArgumentException("The suit must be one of te following: Club\nHeart\nDiamond\nSpade");
        }
    }

    public CardOfWar() {
    }

    public int getRank() {
        return rank.getRankValue();
    }

    public String getSuit() {
        return suit.getSuitName();
    }

    public void setRank(int rank) {
        boolean isFound = true;
        for (Rank r : Rank.values()) {
            if (r.getRankValue() == rank) {
                this.rank = r;
                isFound = false;
            }
        }
        if (isFound) {
            throw new IllegalArgumentException("The rank must in the range from 1-13");
        }
    }

    public void setSuit(String suit) {
        boolean isFound = true;
        for (Suit s : Suit.values()) {
            if (s.getSuitName().equalsIgnoreCase(suit)) {
                this.suit = s;
                isFound = false;
            }
        }
        if (isFound) {
            throw new IllegalArgumentException("The suit must be one of te following: Club\nHeart\nDiamond\nSpade");
        }
    }

    public int compareTo(CardOfWar card) {
        if (rank.getRankValue() > card.getRank()) {
            return 1;
        } else if (rank.getRankValue() < card.getRank()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%s of %s's", rank.getRankName(), suit.getSuitName());
    }

}
