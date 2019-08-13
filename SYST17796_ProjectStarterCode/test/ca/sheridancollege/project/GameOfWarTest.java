/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kiran
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

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("After Class");
    }

    @Before
    public void setUp() {
        System.out.println("Before Test");
    }

    @After
    public void tearDown() {
        System.out.println("After Class");
    }

    /**
     * Test of play method, of class GameOfWar.
     */
    @Test
    public void testGoodDeclareResult() {
        System.out.println("declareResult");
        CardOfWar c1 = new CardOfWar("TWO", "SPADE");
        CardOfWar c2 = new CardOfWar("ACE", "HEART");
        String expResult = "won";
        String result = gow.declareResult(c1, c2, true);
        assertEquals(expResult, result);

    }

    @Test
    public void testBadDeclareResult() {
        System.out.println("declareResult");
        CardOfWar c2 = new CardOfWar("TWO", "SPADE");
        CardOfWar c1 = new CardOfWar("ACE", "HEART");
        String expResult = "lost";
        String result = gow.declareResult(c1, c2, true);
        assertEquals(expResult, result);

    }

    @Test
    public void testBoundaryDeclareResult() {
        System.out.println("declareResult");
        CardOfWar c1 = new CardOfWar("ACE", "HEART");
        CardOfWar c2 = new CardOfWar("ACE", "HEART");
        String expResult = "tie";
        String result = gow.declareResult(c1, c2, true);
        assertEquals(expResult, result);
    }

}