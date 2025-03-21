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
	 void testInitialResources() {
		 for (Ressource r : Ressource.values()) {
			 assertTrue(player.hasResources(r, 10), "Player should start with 10 of " + r);
		 }
	 }

}
