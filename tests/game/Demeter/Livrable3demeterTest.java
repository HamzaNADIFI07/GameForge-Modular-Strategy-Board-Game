package game.Demeter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Player;
import ressource.Ressource;
import tuile.Tuile;

public class Livrable3demeterTest {
	private Demeter game;
	private Player player;
	private int fermeX = 2, fermeY = 2;
	private int portX = 4, portY = 4;

	@BeforeEach
	void setUp() {
		player = new Player("Leon");
		List<Player> players = new ArrayList<>();
		players.add(player);
		
		game = new Demeter(players, 10, 10);
		game.setCurrentPlayer(player);
		Tuile tuileFerme = game.getPlateau().getTuile(fermeX, fermeY);
		Tuile tuilePort = game.getPlateau().getTuile(portX, portY);
		
		player.addTuile(tuileFerme);
		player.addTuile(tuilePort);
		// Remplissage généreux des ressources pour éviter tout blocage
		for (Ressource r : Ressource.values()) {
			player.addRessource(r, 20);
		}
	}
	@Test
	void testDemeterMainSequence() {
		// 1. Construire une ferme
		game.getAction().construireFerme(fermeX, fermeY);
		assertTrue(player.getBatimentsPossedes().stream()
				.anyMatch(b -> b.getClass().getSimpleName().equals("Ferme")));
		
		// 2. Transformer la ferme en exploitation
		game.getAction().construireExploitation(fermeX, fermeY);
		assertTrue(player.getBatimentsPossedes().stream()
				.anyMatch(b -> b.getClass().getSimpleName().equals("Exploitation")));
		// 3. Construire un port
		game.getAction().construirePort(portX, portY);
		assertTrue(player.getBatimentsPossedes().stream()
				.anyMatch(b -> b.getClass().getSimpleName().equals("Port")));
		
		// 4. Échange 3 ressources contre 1 sans port
		game.getAction().echangerRessources(1, Ressource.Ble, Ressource.Minerai, false);
		
		// 5. Échange 2 ressources contre 1 via port
		game.getAction().echangerRessources(1, Ressource.Bois, Ressource.Bois, true);
		
		// 6. Vérifier les bâtiments
		assertEquals(2, player.getBatimentsPossedes().size(), "Le joueur devrait avoir 2 bâtiments");
		
		// 7. Vérifier les tuiles occupées
		assertEquals(2, player.getDisplayTuilesPossedes().size(), "Le joueur devrait occuper 2 tuiles");
		
		// 8. Vérifier les ressources présentes
		assertNotNull(player.getRessources());
		assertFalse(player.getRessources().isEmpty());
	}

}
