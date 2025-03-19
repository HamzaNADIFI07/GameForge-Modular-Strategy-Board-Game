
package game.Ares;

import plateau.Plateau;
import ressource.Ressource;
import tuile.Tuile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import game.Game;
import game.Player;

public class Action_Ares {

    private Player player;

    public Action_Ares(Game game, Player player) {
        this.player = player;
    }

    /*construction d'une ar*/
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

    public boolean remplacerArmeeParCamp(Tuile t) {
    	if (player.hasResources(Ressource.Bois, 2) && player.hasResources(Ressource.Minerai, 3)) {
    		player.useResources(Ressource.Bois, 2);
    		player.useResources(Ressource.Minerai, 3);
    		player.construireBatiment(new batiment.type_batiment.Camp(t), t);
            return true;
        }
        return false;
    }
/**
 * en attendant la creation de la classe Listchooser pour 
 * implimenter cette méthode
    public boolean positionnerGuerriers(String type, int quantity) {
    	List<String> options = Arrays.asList("Armee", "Camp");
    	String choix = listChooser.choose("Sélectionnez où positionner les guerriers:", options);
    	return player.positionWarriors(choix, 5);
    }
    */
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
// reste la méthode attackNeighbor à creer dans player
    public boolean attaquerVoisin(Player voisin) {
        return player.attackNeighbor(voisin);
    }

    public boolean acheterArmeSecrete() {
    	if (player.hasResources(Ressource.Minerai, 1) && player.hasResources(Ressource.Bois, 1)) {
    		player.useResources(Ressource.Minerai, 1);
    		player.useResources(Ressource.Bois, 1);
            player.buySecretWeapon();
            return true;
        }
        return false;
    }
}
    /** a terminer 
     *  
    public void echangerRessources(int nbDonnes, Ressource rDonnee, Ressource rVoulue, boolean viaPort){
        int ratio = viaPort ? 2 : 3;
       //Vérifier si le joueur possède un port avant d'autoriser un échange à 2:1 
           boolean hasPort = batimentsPossedes.stream().anyMatch(b -> b instanceof batiment.type_batiment.Port);
           if (viaPort && !hasPort) {
            System.out.println("Échange impossible : vous n'avez pas de port.");
            return;
        }
        if (!hasResources( rDonnee, amount)) {
                    System.out.println("Échange impossible : ressources insuffisantes.");
                    return;
            }
        }} */
        
        