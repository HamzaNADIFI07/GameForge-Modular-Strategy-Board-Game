package game.Ares;

import java.util.Scanner;

import batiment.type_batiment.Armee;
import game.Player;
import plateau.Plateau;
import tuile.Tuile;

public class Livrable3ares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width, height;
        while (true) {
            try {
                System.out.print("Entrez la largeur du plateau (minimum 10): ");
                width = Integer.parseInt(scanner.nextLine());
                System.out.print("Entrez la hauteur du plateau (minimum 10): ");
                height = Integer.parseInt(scanner.nextLine());

                if (width >= 10 && height >= 10) {
                    break;  
                } else {
                    System.out.println("Les dimensions doivent être supérieures ou égales à 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer des nombres valides.");
            }
        }

        scanner.close();  
        Plateau plateau = new Plateau(width, height);
        Player player = new Player("Leon");

        System.out.println("Plateau généré pour Ares:");
        plateau.display();
     // Sélectionner une tuile valide pour l'armée
        Tuile tuileArmee = null;
        for (Tuile[] row : plateau.getTuiles()) {
        	for (Tuile t : row) {
        		 if (t.getBatiment() == null && !t.getType().equals("Mer")) {
        			 tuileArmee = t;
        			 break;
        		 }
        	}
        	if (tuileArmee != null) break;
        }
        if (tuileArmee != null) {
        	Armee armee = new Armee(tuileArmee, 1);
        	player.construireBatiment(armee, tuileArmee);
        	player.afficherRessources();
        }

    }
}











/*package game.Ares;

import game.Game;
import game.Player;
import ressource.Ressource;
import tuile.Tuile;
import java.util.List;

public class Livrable3_Ares {

    private Player player;
    private Game game;

    public Livrable3_Ares(Game game, Player player) {
        this.player = player;
        this.game = game;
    }

    public void executerActions(Tuile t) {
        Action_Ares actions = new Action_Ares(game, player);
        
        // 1. Construire une armée avec 1 guerrier
        if (actions.construireArmee(t)) {
            afficherRessources();
        }
        
        // 2. Ajouter des guerriers pour arriver à 5
        if (actions.ajouterGuerriersAuStock()) {
            actions.positionnerGuerriers("Armee", 4);
            afficherRessources();
        }
        
        // 3. Transformer l'armée en un camp
        if (actions.remplacerArmeeParCamp(t)) {
            afficherRessources();
        }
        
        // 4. Acheter 5 guerriers
        if (actions.ajouterGuerriersAuStock()) {
            afficherRessources();
        }
        
        // 5. Construire un port
        if (actions.construirePort(t)) {
            afficherRessources();
        }
        
        // 6. Échanger 3 ressources contre 1
        actions.echangerRessourcesIdentiques(3, Ressource.Bois, Ressource.Ble);
        afficherRessources();
        
        // 7. Acheter une arme secrète
        if (actions.acheterArmeSecrete()) {
            afficherRessources();
        }
        
        // Afficher les bâtiments et tuiles occupées
        afficherBatimentsEtTuiles();
    }

    private void afficherRessources() {
        System.out.println("Ressources du joueur : " + player.getRessources());
    }

    private void afficherBatimentsEtTuiles() {
        List<?> batiments = player.getBatiments();
        List<Tuile> tuiles = player.getTuilesOccupees();
        
        System.out.println("Bâtiments du joueur : " + batiments);
        System.out.println("Tuiles occupées par le joueur : " + tuiles);
    }
}*/
