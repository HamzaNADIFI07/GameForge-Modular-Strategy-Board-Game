package game;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat.Field;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import batiment.type_batiment.Armee;
import batiment.type_batiment.Port;
import plateau.Plateau;
import ressource.Ressource;
import tuile.Tuile;

class PlayerTest {
	private Player player ;
	
	@BeforeEach
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
		assertTrue(player.hasResources(Ressource.Bois, 10));
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
	/*
	 * Tests if warriors can be added to the player's stock.
     */
	@Test 
	void testAddWarriors() {
		player.addWarriors(5);
		assertTrue(player.hasWarriorsInStock(5));
	}
	/*
	 * Tests if the player can buy a secret weapon
	 */
	@Test 
	void testBuySecretWeapon() {
		 player.useResources(Ressource.Minerai, 1);
		 player.useResources(Ressource.Bois, 1);
		 player.buySecretWeapon();
	}
	/*
	 * Tests if the player has a port in their buildings
	 */
	@Test 
	void testHasPort() {
		assertFalse(player.getBatimentsPossedes().stream().anyMatch(b -> b instanceof Port));
		player.getBatimentsPossedes().add(new Port(null));
		 assertTrue(player.getBatimentsPossedes().stream().anyMatch(b -> b instanceof Port));
	}
	
	 
	
	 

}
