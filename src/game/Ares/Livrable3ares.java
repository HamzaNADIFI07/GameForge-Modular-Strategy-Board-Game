package game.Ares;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import batiment.Batiment;
import batiment.type_batiment.Armee;
import game.Player;
import plateau.Plateau;
import ressource.Ressource;
import tuile.Tuile;
import game.Ares.Ares;

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
        List<Player> players = new ArrayList<>();
        players.add(player);
        
        Ares ares = new Ares(players, width, height) {
        	private final Action_Ares action = new Action_Ares(this, player);
        	public Action_Ares getAction() {
        		return action;
        	}
        	@Override
        	public void initializeGame() {
        		
        	}
        };
        ares.setCurrentPlayer(player);
        Action_Ares action = ares.getAction();
        System.out.println("\n-----------------");
        System.out.println("-----   ARES  -----");
        System.out.println("-----------------\n");
        
     // Étape 1 : construire une armée avec 1 guerrier
        Tuile tuileArmee = ares.trouverTuileConstruisible("Armee");
        System.out.println("----> " + player.getName() + ": " + player.getRessources() + " (" + player.getWarriorsStock() + " warriors) veut construire une armée");
        action.construireArmee(tuileArmee);
     // 2. Ajouter des guerriers jusqu’à 5
        System.out.println("----> " + player.getName() + " ajoute des guerriers à son armée pour arriver à 5");
        List<Batiment> armees = player.getBatimentsParType("Armee");
        if (!armees.isEmpty()) {
        	Armee armee = (Armee) armees.get(0);
        	armee.addGuerriers(1);
        	armee.addGuerriers(1);
        }
     // 3. Transformer en camp
        System.out.println("----> " + player.getName() + " veut transformer son armée en camp");
        action.remplacerArmeeParCamp(tuileArmee);
        
     // 4. Acheter 5 guerriers
        System.out.println("----> " + player.getName() + " achète 5 guerriers");
        action.ajouterGuerriersAuStock();
        
     // 5. Construire un port
        System.out.println("----> " + player.getName() + " veut construire un port");
        Tuile tuilePort = ares.trouverTuileConstruisible("Port");
        action.construirePort(tuilePort);
        
     // 6. Échange 3 ressources contre 1
        System.out.println("----> " + player.getName() + " échange des ressources");
        player.echangerRessources(3, Ressource.Bois, Ressource.Minerai, false);

     // 7. Acheter une arme secrète
        System.out.println("----> " + player.getName() + " achète une arme secrète");
        player.buySecretWeapon();

     // Affichage final
        System.out.println("----> État final des ressources :");
        System.out.println(player.getRessources());
        
        System.out.println("----> Liste des bâtiments en sa possession");
        System.out.println(player.getDisplayBatiments());
        
        System.out.println("----> Liste des tuiles occupées");
        System.out.println(player.getDisplayTuilesPossedes());
        scanner.close();

    }
}

