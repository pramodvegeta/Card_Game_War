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
    
    public GameOfWarTest() {
        PlayerOfWar p1 = new PlayerOfWar("name");
        PlayerOfWar p2 = new PlayerOfWar("Computer");
//        PlayerOfWar tie = new PlayerOfWar("tie");
        gow.getPlayers().add(p1);
        gow.getPlayers().add(p2);
//        gow.getPlayers().add(tie);
        gow.play();
    }
     GameOfWar gow = new GameOfWar("War");
 
//@BeforeClass
//        public static void check() {
//           
       
   

   

  

    /**
     * Test of declareResult method, of class GameOfWar.
     */
    @Test
    public void testGoodDeclareResult() {
        System.out.println("declareResult");
        CardOfWar c1 = new CardOfWar("TWO","SPADE");
        CardOfWar c2 = new CardOfWar("ACE","HEART");
       // boolean war = true;
       // GameOfWar instance = new GameOfWar("");
        String expResult = "won";
        String result = gow.declareResult(c1, c2, true);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testBadDeclareResult() {
        System.out.println("declareResult");
        CardOfWar c2 = new CardOfWar("TWO","SPADE");
        CardOfWar c1 = new CardOfWar("ACE","HEART");
       // boolean war = true;
       // GameOfWar instance = new GameOfWar("");
        String expResult = "lost";
        String result = gow.declareResult(c1, c2, true);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testBoundaryDeclareResult() {
        System.out.println("declareResult");
        CardOfWar c1 = new CardOfWar("ACE","HEART");
        CardOfWar c2 = new CardOfWar("ACE","HEART");
       // boolean war = true;
       // GameOfWar instance = new GameOfWar("");
        String expResult = "tie";
        String result = gow.declareResult(c1, c2, true);
        assertEquals(expResult, result);
        
    }


    /**
     * Test of isWinner method, of class GameOfWar.
     */
//    @Test
//    public void testIsWinner() {
//        System.out.println("isWinner");
//        GameOfWar instance = new GameOfWar("true") ;
//        boolean expResult = "";
//        boolean result = instance.isWinner();
//        assertEquals(expResult, result);
//        
//    }
    
}
