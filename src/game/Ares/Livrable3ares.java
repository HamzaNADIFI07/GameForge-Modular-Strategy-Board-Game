package game.Ares;

import batiment.Batiment;
import batiment.type_batiment.Armee;
import game.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.PlateauSwing;
import ressource.Ressource;
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

      Player player = new Player("Leon");
      List<Player> players = new ArrayList<>();
      players.add(player);
        
      Ares ares = new Ares(players, width, height);

      ares.setCurrentPlayer(player);
      Action_Ares action = ares.getAction();
      System.out.println("\n-----------------");
      System.out.println("-----   ARES  -----");
      System.out.println("-----------------\n");
        
      // Étape 1 : construire une armée avec 1 guerrier
      System.out.println("----> " + player.getName() + ": " + player.getRessources() + " (" + player.getWarriorsStock() + " warriors) veut construire une armée");
      System.out.println();
      System.out.println("Où installer une armée ?");
      int coordonneeX;
		int coordonneeY;
		while (true) {
			try {
				System.out.print("Entrez la coordonnée X: ");
				coordonneeX = Integer.parseInt(scanner.nextLine());
				System.out.println();
				System.out.print("Entrez la la coordonnée Y: ");
				coordonneeY = Integer.parseInt(scanner.nextLine());

				if (coordonneeX <= width && coordonneeY <= height) {
					break;
				} else {
					System.out.println("La coordonnée X doit être inférieur ou égale à " + width + " et la coordonnée Y doit être inférieur ou égale à " + height +".");
				}
			} catch (NumberFormatException e) {
				System.out.println("Veuillez entrer des nombres valides.");
			}
		}
      Tuile tuileArmee = ares.getPlateau().getTuile(coordonneeX, coordonneeY);

      action.construireArmee(tuileArmee);

      System.out.println();
      System.out.println();
      
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
      // Affichage dans une fenêtre Swing
      PlateauSwing.afficherPlateau(ares.getPlateau());

   }
}

