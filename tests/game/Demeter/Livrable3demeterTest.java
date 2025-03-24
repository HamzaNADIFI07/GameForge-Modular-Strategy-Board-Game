package game.Demeter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Player;
import ressource.Ressource;
import tuile.Tuile;

class Livrable3demeterTest {
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

}
