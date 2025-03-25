
package game.Ares;

import game.Game;
import game.Player;
import ressource.Ressource;
import tuile.Tuile;

public class Action_Ares {

    private Player player;

    public Action_Ares(Game game, Player player) {
        this.player = player;
    }

    /*construction d'une armée*/

    public boolean construireArmee(Tuile t) {
    	if (player.hasResources(Ressource.Bois, 1) && player.hasResources(Ressource.Moutons, 1)
    		&& player.hasResources(Ressource.Ble, 1) && player.hasWarriorsInStock(1)) {
        	player.buildArmy(t);
        	return true;
        }
        return false;
    }
    /*construction d'un port */

    public boolean construirePort(Tuile t) {
    	if (player.hasResources(Ressource.Bois, 1) && player.hasResources(Ressource.Moutons, 2)) {
    		player.useResources(Ressource.Bois, 1);
    		player.useResources(Ressource.Moutons, 2);
    		player.construireBatiment(new batiment.type_batiment.Port(t), t);
            return true;
        }
        return false;
    }

    /*remplacer armée par le camp */

    public boolean remplacerArmeeParCamp(Tuile t) {
    	if (player.hasResources(Ressource.Bois, 2) && player.hasResources(Ressource.Minerai, 3)) {
    		player.useResources(Ressource.Bois, 2);
    		player.useResources(Ressource.Minerai, 3);
    		player.construireBatiment(new batiment.type_batiment.Camp(t), t);
            return true;
        }
        return false;
    }


    /** Positionner des gueriers dans une armée ou dans un camp */
    public boolean positionnerGuerriers(String type, int quantity) {
        if (!player.hasWarriorsInStock(quantity)) {
            System.out.println("Positionnement impossible : guerriers insuffisants dans le stock");
            return false;
        }
        if (type.equals("Armee")) {
            player.positionWarriorsInArmy(quantity);
        } else if (type.equals("Camp")) {
            player.positionWarriorsInCamp(quantity);
        } else {
            System.out.println("Type de positionnement inconnu");
            return false;
        }
        return true;
    }

    /*ajouter des guerriers au stock*/

    public boolean ajouterGuerriersAuStock() {
    	if (player.hasResources(Ressource.Ble, 2) && player.hasResources(Ressource.Moutons, 2) && player.hasResources(Ressource.Minerai, 1)) {
    		player.useResources(Ressource.Ble, 2);
    		player.useResources(Ressource.Moutons, 2);
    		player.useResources(Ressource.Minerai, 1);
    		player.addWarriors(5);
            return true;
        }
        return false;
    }

/* attaquer son voisin*/

public boolean attaquerVoisin(Player voisin) {
    if (player.hasWarriorsInStock(1)) {
        player.useWarriors(1);
        return player.attackNeighbor(voisin);
    }
    return false;
}

/* acheter une arme secrete*/

    public boolean acheterArmeSecrete() {
    	if (player.hasResources(Ressource.Minerai, 1) && player.hasResources(Ressource.Bois, 1)) {
    		player.useResources(Ressource.Minerai, 1);
    		player.useResources(Ressource.Bois, 1);
            player.buySecretWeapon();
            return true;
        }
        return false;
    }

// echanger trois ressouces identiques contre une autre ressource

    public void echangerRessourcesIdentiques(int nbDonnes, Ressource rDonnee, Ressource rVoulue) {
        if (nbDonnes % 3 != 0) {
            System.out.println("Échange impossible : le nombre de ressources données doit être un multiple de 3");
            return;
        }
        int setsOfThree = nbDonnes / 3;
        if (!player.hasResources(rDonnee, nbDonnes)) {
            System.out.println("Échange impossible : ressources insuffisantes");
            return;
        }
        player.useResources(rDonnee, nbDonnes);
        player.getRessources().put(rVoulue, player.getRessources().getOrDefault(rVoulue, 0) + setsOfThree);
    }
    
}
