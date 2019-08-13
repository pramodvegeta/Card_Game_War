/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kiran
 */
public class CardOfWarTest {
    
    public CardOfWarTest() {
    }

    /**
     * Test of toString method, of class CardOfWar.
     */
     @Test
    public void testGoodCompareTo() {
        System.out.println("Testing the compareTo method");
        CardOfWar instance1 = new CardOfWar("TWO","SPADE");
        CardOfWar instance2 = new CardOfWar("ACE","HEART");
        int expResult = 1;
        int result = instance1.compareTo(instance2);
        assertEquals(expResult, result);
    }
    @Test
    public void testBoundaryCompareTo() {
        System.out.println("Testing the compareTo method");
        CardOfWar instance1 = new CardOfWar("ACE","SPADE");
        CardOfWar instance2 = new CardOfWar("ACE","HEART");
        int expResult = 0;
        int result = instance1.compareTo(instance2);
        assertEquals(expResult, result);
    }
     @Test
    public void testBadCompareTo() {
        System.out.println("Testing the compareTo method");
        CardOfWar instance1 = new CardOfWar("ACE","SPADE");
        CardOfWar instance2 = new CardOfWar("TWO","HEART");
        int expResult = -1;
        int result = instance1.compareTo(instance2);
        assertEquals(expResult, result);
    }
    
}
