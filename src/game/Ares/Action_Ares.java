
package game.Ares;

import game.Game;
import game.Player;
import ressource.Ressource;
import tuile.Tuile;

public class Action_Ares {

    private Game game;
    
    public Action_Ares(Game game) {
        this.game = game;
    }

    /*construction d'une armée*/

    public boolean construireArmee(Tuile t) {
        Player currentPlayer = game.getCurrentPlayer();
    	if (currentPlayer.hasResources(Ressource.Bois, 1) && currentPlayer.hasResources(Ressource.Moutons, 1)
    		&& currentPlayer.hasResources(Ressource.Ble, 1) && currentPlayer.hasWarriorsInStock(1)) {
                currentPlayer.buildArmy(t);
                System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " a construit une armée sur "+ t.display());
        	return true;
        }
        return false;
    }
    /*construction d'un port */

    public boolean construirePort(Tuile t) {
        Player currentPlayer = game.getCurrentPlayer();
    	if (currentPlayer.hasResources(Ressource.Bois, 1) && currentPlayer.hasResources(Ressource.Moutons, 2)) {
    		currentPlayer.useResources(Ressource.Bois, 1);
    		currentPlayer.useResources(Ressource.Moutons, 2);
    		currentPlayer.construireBatiment(new batiment.type_batiment.Port(t), t);
            return true;
        }
        return false;
    }

    /*remplacer armée par le camp */

    public boolean remplacerArmeeParCamp(Tuile t) {
        Player currentPlayer = game.getCurrentPlayer();
    	if (currentPlayer.hasResources(Ressource.Bois, 2) && currentPlayer.hasResources(Ressource.Minerai, 3)) {
    		currentPlayer.useResources(Ressource.Bois, 2);
    		currentPlayer.useResources(Ressource.Minerai, 3);
    		currentPlayer.construireBatiment(new batiment.type_batiment.Camp(t), t);
            return true;
        }
        return false;
    }


    /** Positionner des gueriers dans une armée ou dans un camp */
    public boolean positionnerGuerriers(String type, int quantity) {
        Player currentPlayer = game.getCurrentPlayer();
        if (!currentPlayer.hasWarriorsInStock(quantity)) {
            System.out.println("Positionnement impossible : guerriers insuffisants dans le stock");
            return false;
        }
        if (type.equals("Armee")) {
            currentPlayer.positionWarriorsInArmy(quantity);
        } else if (type.equals("Camp")) {
            currentPlayer.positionWarriorsInCamp(quantity);
        } else {
            System.out.println("Type de positionnement inconnu");
            return false;
        }
        return true;
    }

    /*ajouter des guerriers au stock*/

    public boolean ajouterGuerriersAuStock() {
        Player currentPlayer = game.getCurrentPlayer();
    	if (currentPlayer.hasResources(Ressource.Ble, 2) && currentPlayer.hasResources(Ressource.Moutons, 2) && currentPlayer.hasResources(Ressource.Minerai, 1)) {
    		currentPlayer.useResources(Ressource.Ble, 2);
    		currentPlayer.useResources(Ressource.Moutons, 2);
    		currentPlayer.useResources(Ressource.Minerai, 1);
    		currentPlayer.addWarriors(5);
            return true;
        }
        return false;
    }

/* attaquer son voisin*/

public boolean attaquerVoisin(Player voisin) {
    Player currentPlayer = game.getCurrentPlayer();
    if (currentPlayer.hasWarriorsInStock(1)) {
        currentPlayer.useWarriors(1);
        return currentPlayer.attackNeighbor(voisin);
    }
    return false;
}

/* acheter une arme secrete*/

    public boolean acheterArmeSecrete() {
        Player currentPlayer = game.getCurrentPlayer();
    	if (currentPlayer.hasResources(Ressource.Minerai, 1) && currentPlayer.hasResources(Ressource.Bois, 1)) {
    		currentPlayer.useResources(Ressource.Minerai, 1);
    		currentPlayer.useResources(Ressource.Bois, 1);
            currentPlayer.buySecretWeapon();
            return true;
        }
        return false;
    }

// echanger trois ressouces identiques contre une autre ressource

    public void echangerRessourcesIdentiques(int nbDonnes, Ressource rDonnee, Ressource rVoulue) {
        Player currentPlayer = game.getCurrentPlayer();
        if (nbDonnes % 3 != 0) {
            System.out.println("Échange impossible : le nombre de ressources données doit être un multiple de 3");
            return;
        }
        int setsOfThree = nbDonnes / 3;
        if (!currentPlayer.hasResources(rDonnee, nbDonnes)) {
            System.out.println("Échange impossible : ressources insuffisantes");
            return;
        }
        currentPlayer.useResources(rDonnee, nbDonnes);
        currentPlayer.getRessources().put(rVoulue, currentPlayer.getRessources().getOrDefault(rVoulue, 0) + setsOfThree);
    }
    
}
