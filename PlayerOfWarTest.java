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
public class PlayerOfWarTest {
    
    public PlayerOfWarTest() {
    }
    
   

    /**
     * Test of setPlayerID method, of class PlayerOfWar.
     */
    @Test
    public void testGoodSetPlayerID() {
        System.out.println("setPlayerID");
        String playerID = "kiran";
        PlayerOfWar instance = new PlayerOfWar("");
        instance.setPlayerID(playerID);
        String result = instance.getPlayerID();
        assertEquals(playerID, result);
    }
    
    
    /**
     * Test of checkNumbers method, of class PlayerOfWar.
     */
    @Test
    public void testBadSetPlayerID() {
        System.out.println("checkNumbers");
         String playerID = "kiran123";
        PlayerOfWar instance = new PlayerOfWar("");
        instance.setPlayerID(playerID);
        String result = instance.getPlayerID();
       assertEquals("", result);
    }

    
    
}