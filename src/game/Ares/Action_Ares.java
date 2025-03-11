
package game.Ares;

import plateau.Plateau;
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
    public boolean construireArmee() {
        if (player.hasResources("bois", 1) && player.hasResources("mouton", 1) && player.hasResources("ble", 1) && player.hasWarriorInStock()) {
            player.useResources("bois", 1);
            player.useResources("mouton", 1);
            player.useResources("ble", 1);
            player.buildArmy();
            return true;
        }
        return false;
    }

    public boolean construirePort() {
        if (player.hasResources("bois", 1) && player.hasResources("mouton", 2)) {
            player.useResources("bois", 1);
            player.useResources("mouton", 2);
            player.buildPort();
            return true;
        }
        return false;
    }

    public boolean remplacerArmeeParCamp() {
        if (player.hasResources("bois", 2) && player.hasResources("minerai", 3)) {
            player.useResources("bois", 2);
            player.useResources("minerai", 3);
            player.replaceArmyWithCamp();
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


