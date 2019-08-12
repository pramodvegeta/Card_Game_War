/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author judda
 */
public enum Suit {
    HEART("Heart"),
    CLUB("Club"),
    DIAMOND("Diamond"),
    SPADE("Spade");

    public String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    public String getSuitName() {
        return suit;
    }
}
