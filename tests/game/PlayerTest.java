package game;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat.Field;
import java.util.Map;

import org.junit.jupiter.api.Test;

import ressource.Ressource;

class PlayerTest {
	private Player player ;
	@Test
	void setUp() {
		player = new Player("Leon");
	}
	/*
	 * Tests if the player starts with enough resources*
	 */
	@Test
	 void testInitialResources() {
		 for (Ressource r : Ressource.values()) {
			 assertTrue(player.hasResources(r, 10), "Player should start with 10 of " + r);
		 }
	 }
	 /*
	  * Tests if the player correctly verifies resource availability.
	  */
	@Test
	 void testHasResources() {
		assertTrue(player.hasResources(Ressource.Bois, 5));
		assertFalse(player.hasResources(Ressource.Minerai, 20));
	}
	/*
	 * Tests the useResources() method to verify that resources are correctly deducted.
	 */
	@Test 
	void testUseResources() {
		assertTrue(player.useResources(Ressource.Bois, 3));
		assertFalse(player.useResources(Ressource.Bois, 20));
	}
	
	 

}
