
package game.Ares;

import batiment.Batiment;
import batiment.type_batiment.Armee;
import batiment.type_batiment.Camp;
import batiment.type_batiment.Port;
import game.Game;
import game.Player;
import java.util.Random;
import ressource.Ressource;
import tuile.Tuile;

public class Action_Ares {

    private Game game;
    
    public Action_Ares(Game game) {
        this.game = game;
    }

    /*construction d'une armée*/

    public void construireArmee(Tuile t, int nb) {
        Player currentPlayer = game.getCurrentPlayer();
        if (nb>=1) {
			if (currentPlayer.hasResources(Ressource.Bois, 1) &&
                currentPlayer.hasResources(Ressource.Moutons, 1) &&
                 currentPlayer.hasResources(Ressource.Ble, 1) &&
                currentPlayer.hasWarriorsInStock(nb) &&
                this.game.batimentPeutEtreConstruit("Armee",t)) {

				currentPlayer.useResources(Ressource.Bois, 1);
				currentPlayer.useResources(Ressource.Moutons, 1);
				currentPlayer.useResources(Ressource.Ble, 1);
				currentPlayer.addWarriors(-nb);
				Armee armee = new Armee(t, nb);
                currentPlayer.getBatimentsPossedes().add(armee);
                currentPlayer.addTuile(t);
                armee.setPlayer(currentPlayer);
                System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " (" +currentPlayer.getWarriorsStock() + ") a construit une armée sur "+ t.display() + " en déployant " + nb + " guérriers.");
			} else {
				System.out.println("Construction d'armée impossible: ressources ou guerriers insuffisants.");
			}
		}else{
			System.out.println("Vous devrez au moins déployer un guerriers pour construire une armée");
		}
    }

    public void construireArmeeGratuitement(Tuile t, int nb) {
        Player currentPlayer = game.getCurrentPlayer();
        if (nb>=1) {
			if (this.game.batimentPeutEtreConstruit("Armee",t)) {


				Armee armee = new Armee(t, nb);
                currentPlayer.getBatimentsPossedes().add(armee);
                currentPlayer.addTuile(t);
                armee.setPlayer(currentPlayer);
                System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " (" +currentPlayer.getWarriorsStock() + ") a construit une armée sur "+ t.display() + " en déployant " + nb + " guérriers.");
			} else {
				System.out.println("Construction d'armée impossible: ressources ou guerriers insuffisants.");
			}
		}else{
			System.out.println("Vous devrez au moins déployer un guerriers pour construire une armée");
		}
    }


    /**
     * Construit un port sur la tuile aux coordonnées données si les ressources sont suffisantes.
     *
     * @param t Tuile sur laquelle construire le port
     */
    public void construirePort(Tuile t){
        Player currentPlayer = game.getCurrentPlayer();

        if(currentPlayer.hasResources(Ressource.Bois, 1) && 
            currentPlayer.hasResources(Ressource.Moutons, 2) && 
            this.game.batimentPeutEtreConstruit("Port",t)){

            currentPlayer.useResources(Ressource.Bois, 1);
            currentPlayer.useResources(Ressource.Moutons, 2);
            Port port = new Port(t);
            currentPlayer.getBatimentsPossedes().add(port);
            currentPlayer.setPort(1);
            currentPlayer.addTuile(t);
            port.setPlayer(currentPlayer);
            System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " a construit un port sur "+ t.display());
        }else{
            System.out.println("Vous ne pouvez pas construire un port sur cette tuile");
        }
    }

    /*remplacer armée par le camp */

    public void remplacerArmeeCamp(Tuile tuile){
        Player currentPlayer = game.getCurrentPlayer();

        if(currentPlayer.hasResources(Ressource.Bois, 2) && 
            currentPlayer.hasResources(Ressource.Minerai, 3) && 
            this.game.batimentPeutEtreConstruit("Camp",tuile)){

            currentPlayer.useResources(Ressource.Bois, 2);
            currentPlayer.useResources(Ressource.Minerai, 3);
            Batiment armee = tuile.getBatiment();
            int nbGuerriers = armee.getDimension();
            tuile.setBatiment(null);
            currentPlayer.getBatimentsPossedes().remove(armee);
            Camp camp = new Camp(tuile, nbGuerriers );
            currentPlayer.getBatimentsPossedes().add(camp);
            camp.setNbGuerriers(nbGuerriers);
            camp.setPlayer(currentPlayer);
            System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " (" +currentPlayer.getWarriorsStock() + ") a construit un camp sur "+ tuile.display());
        }else{
            System.out.println("Vous ne pouvez pas construire un camp sur cette tuile");
        }
    }


    /** Positionner des gueriers dans une armée ou dans un camp */
    public void positionnerGuerriers(Tuile tuile , int nb) {
        Player currentPlayer = game.getCurrentPlayer();
        if (!currentPlayer.hasWarriorsInStock(nb)) {
            System.out.println("Positionnement impossible : guerriers insuffisants dans le stock");
        }
        else if (tuile.getBatiment().getType().equalsIgnoreCase("Armee")||tuile.getBatiment().getType().equalsIgnoreCase("Camp")) {
            if (tuile.getBatiment().getDimension() + nb > 5) {
                System.out.println("Positionnement impossible : l'armée est pleine");
                return;
            }
            tuile.getBatiment().increaseDimension(nb);
            currentPlayer.addWarriors(-nb);
            System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " (" +currentPlayer.getWarriorsStock() + " warriors) a déployé " + nb + " guérriers dans l'armée " + tuile.display());
        }
    }

    /*ajouter des guerriers au stock*/

    public void ajouterGuerriersAuStock() {
        Player currentPlayer = game.getCurrentPlayer();
    	if (currentPlayer.hasResources(Ressource.Ble, 2) && currentPlayer.hasResources(Ressource.Moutons, 2) && currentPlayer.hasResources(Ressource.Minerai, 1)) {
    		currentPlayer.useResources(Ressource.Ble, 2);
    		currentPlayer.useResources(Ressource.Moutons, 2);
    		currentPlayer.useResources(Ressource.Minerai, 1);
    		currentPlayer.addWarriors(5);
            System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " (" +currentPlayer.getWarriorsStock() + " warriors) a acheté 5 guerriers");
        }
        else {
            System.out.println("Achat impossible : ressources insuffisantes");
        }
    }

/* attaquer son voisin*/



    public void attaquer(Tuile batimentAttaquant, Player defenseur, Tuile batimentDefenseur) {
        Player attaquant = game.getCurrentPlayer();
        Random random = new Random();

        int nbGuerriersAttaquant = batimentAttaquant.getBatiment().getDimension();
        int nbGuerriersDefenseur = batimentDefenseur.getBatiment().getDimension();

        int desAttaquant = getNombreDes(nbGuerriersAttaquant);
        int desDefenseur = getNombreDes(nbGuerriersDefenseur);

        // Si attaquant a une arme secrète
        if (attaquant.getSecretWeapon() > 0) {
            desAttaquant++;
            attaquant.utiliserArmeSecrete();
            System.out.println(attaquant.getName() + " utilise une arme secrète !");
        }

        // Si défenseur a une arme secrète (facultatif si tu veux gérer aussi pour défenseur)
        if (defenseur.getSecretWeapon() > 0) {
            desDefenseur++;
            defenseur.utiliserArmeSecrete();
            System.out.println(defenseur.getName() + " utilise une arme secrète !");
        }

        // Lancer les dés
        int sommeAttaquant = lancerDes(desAttaquant, random);
        int sommeDefenseur = lancerDes(desDefenseur, random);

        System.out.println("Attaquant (" + attaquant.getName() + ") total dés : " + sommeAttaquant);
        System.out.println("Défenseur (" + defenseur.getName() + ") total dés : " + sommeDefenseur);

        // Résultat
        if (sommeAttaquant > sommeDefenseur) {
            System.out.println(attaquant.getName() + " gagne le combat !");
            perdreGuerrier(defenseur, batimentDefenseur);
        } else {
            System.out.println(defenseur.getName() + " repousse l'attaque !");
            perdreGuerrier(attaquant, batimentAttaquant);
        }
    }
    // Calcul du nombre de dés selon nombre de guerriers
    private int getNombreDes(int nbGuerriers) {
        if (nbGuerriers <= 3) return 1;
        if (nbGuerriers <= 7) return 2;
        return 3;
    }

    // Lancer plusieurs dés et faire la somme
    private int lancerDes(int nbDes, Random random) {
        int total = 0;
        for (int i = 0; i < nbDes; i++) {
            total += random.nextInt(6) + 1; // dé entre 1 et 6
        }
        return total;
    }

    // Faire perdre un guerrier au joueur
    private void perdreGuerrier(Player joueur, Tuile tuile) {
        tuile.getBatiment().decreaseDimension(1);
        if (tuile.getBatiment().getDimension() <= 0) {
            tuile.setBatiment(null); // la tuile redevient libre
            System.out.println(joueur.getName() + " perd son bâtiment sur la tuile !");
        }
    }



    /* acheter une arme secrete*/

    public void acheterArmeSecrete() {
        Player currentPlayer = game.getCurrentPlayer();
    	if (currentPlayer.hasResources(Ressource.Minerai, 1) && currentPlayer.hasResources(Ressource.Bois, 1)) {
    		currentPlayer.useResources(Ressource.Minerai, 1);
    		currentPlayer.useResources(Ressource.Bois, 1);
    		currentPlayer.setHasSecretWeapon(1);
            System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " (" +currentPlayer.getWarriorsStock() + " warriors) dispose maintenant d'une arme secrète" );
    	} else {
    		System.out.println("Achat impossible : ressources insuffisantes.");
    	}
    }

    /**
     * Échange des ressources pour le joueur courant.
     *
     * @param quantite Quantité de ressources à échanger
     * @param r1 Ressource donnée par le joueur
     * @param r2 Ressource reçue par le joueur
     */
    public void echangerRessources(int quantite , Ressource r1, Ressource r2){
        Player currentPlayer = game.getCurrentPlayer();

        if(currentPlayer.getPort()>=0){
            currentPlayer.useResources(r1, 3*quantite);
            currentPlayer.addRessource(r2, quantite);
            System.out.println(currentPlayer.getName() + currentPlayer.getRessources() + " a échangé "+ 3*quantite + " " + r1 + " contre " + quantite + " " + r2);
            System.out.println();
            System.out.println("Ressources de "+ currentPlayer.getName() +": " + currentPlayer.getRessources());
        }
        else{
            System.out.println("Vous ne pouvez pas échanger de ressources");
        }
    }

    /**
     * Retourne l'objet Game associé à cette instance d'Action_Ares.
     *
     * @return L'instance de Game associée à cette action.
     */
    public Game getGame() {
        return game;
    }

    
}
