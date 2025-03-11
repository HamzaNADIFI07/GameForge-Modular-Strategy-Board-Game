
package game.Ares;

import plateau.Plateau;
import ressource.Ressource;
import tuile.Tuile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import game.Game;
import game.Player;

public class Action_Ares {

    private Game game;
    private Player player;

    public Action_Ares(Game game, Player player) {
        this.game = game;
        this.player = player;
    }

    /*des propositions sont possibles*/
    public boolean construireArmee(Tuile t) {
    	if (player.hasResources(Ressource.Bois, 1) && player.hasResources(Ressource.Moutons, 1)
    		&& player.hasResources(Ressource.Ble, 1) && player.hasWarriorsInStock(1)) {
        	player.buildArmy(t);
        	return true;
        }
        return false;
    }

    public boolean construirePort(Tuile t) {
    	if (player.hasResources(Ressource.Bois, 1) && player.hasResources(Ressource.Moutons, 2)) {
    		player.useResources(Ressource.Bois, 1);
    		player.useResources(Ressource.Moutons, 2);
    		player.construireBatiment(new batiment.type_batiment.Port(t), t);
            return true;
        }
        return false;
    }

    public boolean remplacerArmeeParCamp(Tuile t) {
    	if (player.hasResources(Ressource.Bois, 2) && player.hasResources(Ressource.Minerai, 3)) {
    		player.useResources(Ressource.Bois, 2);
    		player.useResources(Ressource.Minerai, 3);
    		player.construireBatiment(new batiment.type_batiment.Camp(t), t);
            return true;
        }
        return false;
    }

    public boolean positionnerGuerriers(String type, int quantity) {
        if (player.hasWarriorsInStock(quantity)) {
            player.positionWarriors(type, quantity);
            return true;
        }
        return false;
    }

    public boolean ajouterGuerriersAuStock() {
        if (player.hasResources("ble", 2) && player.hasResources("mouton", 2) && player.hasResources("minerai", 1)) {
            player.useResources("ble", 2);
            player.useResources("mouton", 2);
            player.useResources("minerai", 1);
            player.addWarriorsToStock(5);
            return true;
        }
        return false;
    }

    public boolean attaquerVoisin(Player voisin) {
        return player.attackNeighbor(voisin);
    }

    public boolean acheterArmeSecrete() {
        if (player.hasResources("minerai", 1) && player.hasResources("bois", 1)) {
            player.useResources("minerai", 1);
            player.useResources("bois", 1);
            player.buySecretWeapon();
            return true;
        }
        return false;
    }

    public boolean echangerRessources(String resourceToGive, String resourceToReceive) {
        if (player.hasResources(resourceToGive, 3)) {
            player.useResources(resourceToGive, 3);
            player.addResources(resourceToReceive, 1);
            return true;
        }
        return false;
    }
}


