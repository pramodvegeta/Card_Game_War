/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;


import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Kiran
 */
public class GameOfWarTest {
    

     GameOfWar gow = new GameOfWar("War");

    public GameOfWarTest() {
        PlayerOfWar p1 = new PlayerOfWar("name");
        PlayerOfWar p2 = new PlayerOfWar("Computer");
        gow.getPlayers().add(p1);
        gow.getPlayers().add(p2);
        gow.play();
    }

    /**
     * Test of declareResult method, of class GameOfWar.
     */
    @Test
    public void testGoodDeclareResult() {
        System.out.println("declareResult");
        CardOfWar c1 = new CardOfWar("TWO","SPADE");
        CardOfWar c2 = new CardOfWar("ACE","HEART");
        String expResult = "won";
        String result = gow.declareResult(c1, c2, true);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testBadDeclareResult() {
        System.out.println("declareResult");
        CardOfWar c2 = new CardOfWar("TWO","SPADE");
        CardOfWar c1 = new CardOfWar("ACE","HEART");
        String expResult = "lost";
        String result = gow.declareResult(c1, c2, true);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testBoundaryDeclareResult() {
        System.out.println("declareResult");
        CardOfWar c1 = new CardOfWar("ACE","HEART");
        CardOfWar c2 = new CardOfWar("ACE","HEART");
        String expResult = "tie";
        String result = gow.declareResult(c1, c2, true);
        assertEquals(expResult, result);
    }
    
}
