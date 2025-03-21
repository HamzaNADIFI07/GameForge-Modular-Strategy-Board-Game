package game.Ares;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Game;
import game.Player;
import plateau.Plateau;

class Action_AresTest {
	private Action_Ares actionAres;
	private Player player;
	private Plateau plateau;
	private Game game;
	@BeforeEach
	void setUp() {
		plateau = new Plateau(10, 10);
		player = new Player("Leon");
		actionAres = new Action_Ares(null, player);
	}

}
