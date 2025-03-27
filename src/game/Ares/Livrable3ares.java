package game.Ares;

import game.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.PlateauSwing;
import ressource.Ressource;
import tuile.Tuile;

public class Livrable3ares {
   public static void main(String[] args) {

      System.out.println();
      System.out.println();

      Scanner scanner = new Scanner(System.in);

      int width, height;
      while (true) {
         try {
            System.out.print("Entrez la largeur du plateau: ");
            width = Integer.parseInt(scanner.nextLine());
            System.out.print("Entrez la hauteur du plateau: ");
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

      System.out.println(" ----------------- ");
      System.out.println("-----   ARES  -----");
      System.out.println(" ----------------- ");

      Player player = new Player("Leon");
      List<Player> players = new ArrayList<>();
      players.add(player);
        
      Ares ares = new Ares(players, width, height);

      ares.setCurrentPlayer(player);
      Action_Ares action = ares.getAction();

      System.out.println();

      // Étape 1 : construire une armée avec 1 guerrier
      System.out.println("----> " + player.getName() + ": " + player.getRessources() + " (" + player.getWarriorsStock() + " warriors) veut construire une armée");
      
      System.out.println();

      System.out.println("Où installer une armée ?");

      int coordonneeX;
		int coordonneeY;
      int nbGuerriers;
		while (true) {
			try {
            System.out.println();
				System.out.print("Entrez la coordonnée X: ");
				coordonneeX = Integer.parseInt(scanner.nextLine());

				System.out.println();
				System.out.print("Entrez la la coordonnée Y: ");
				coordonneeY = Integer.parseInt(scanner.nextLine());
            
            System.out.println();
            System.out.print("Entrez le nombre de guerriers que vous voulez déployer ");
				nbGuerriers = Integer.parseInt(scanner.nextLine());

				if (coordonneeX <= width && coordonneeY <= height && nbGuerriers>=1) {
					break;
				} else {
					System.out.println("La coordonnée X doit être inférieur ou égale à " + width + " et la coordonnée Y doit être inférieur ou égale à " + height +", et le nombre de guerriers doit etre supérieure ou égale à 1.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Veuillez entrer des nombres valides.");
			}
		}
      Tuile tuileArmee = ares.getPlateau().getTuile(coordonneeX, coordonneeY);

      System.out.println();

      action.construireArmee(tuileArmee,nbGuerriers);

      System.out.println();
      System.out.println();
      
      // 2. Ajouter des guerriers jusqu’à 5
      System.out.println("----> " + player.getName() + ": " + player.getRessources() + " (" + player.getWarriorsStock() + " warriors) ajoute des guerriers à son armée pour arriver à 5");
      int i=0;
      List<String> displayArmee = player.getDisplayBatimentsParType("Armee",tuileArmee);
      while (i<2) {
         System.out.println();
         System.out.println("où déployer un guerrier ?");
         System.out.println();
         System.out.println(displayArmee.size() + ": " + displayArmee);
         int indiceArmee;
		   while (true) {
			   try {
               System.out.println();
				   System.out.print("Indice de l'armée: ");
				   indiceArmee = Integer.parseInt(scanner.nextLine());
				   if (indiceArmee >= 1 && indiceArmee <= displayArmee.size()) {
				      break;
				   } else {
				      System.out.println("Indice invalide.");
				   }
			   } catch (NumberFormatException e) {
			    	System.out.println("Veuillez entrer un nombre valide.");
			   }
		   }
         System.out.println();
         action.positionnerGuerriers(tuileArmee, 1);
         i++;
      }

      System.out.println();
      System.out.println();

      System.out.println("----> " + player.getName() + ": " + player.getRessources() + " (" + player.getWarriorsStock() + " warriors) veut remplacer son armée par un camp");
      System.out.println();
      System.out.println("Quelle armée transformer en camp ?");
      System.out.println();
      System.out.println(displayArmee.size() + ": " + displayArmee);
      int indiceArmeetoCamp;
      while (true) {
         try {
            System.out.println();
            System.out.print("Indice de l'armée: ");
            indiceArmeetoCamp = Integer.parseInt(scanner.nextLine());
            if (indiceArmeetoCamp >= 1 && indiceArmeetoCamp <= displayArmee.size()) {
               break;
            } else {
               System.out.println("Indice invalide.");
            }
         } catch (NumberFormatException e) {
               System.out.println("Veuillez entrer un nombre valide.");
         }
      }
      System.out.println();

      action.remplacerArmeeCamp(tuileArmee);

      System.out.println();
      System.out.println();

      System.out.println("----> " + player.getName() + ": " + player.getRessources() + " (" + player.getWarriorsStock() + " warriors) achète 5 guerriers");

      System.out.println();

      action.ajouterGuerriersAuStock();

      System.out.println();
      System.out.println();

      System.out.println("----> " + player.getName() + ": " + player.getRessources() + " (" + player.getWarriorsStock() + " warriors) veut construire un port.");

      System.out.println();

      System.out.println("Où installer le port ?");
		
		System.out.println();

		int portX;
		int portY;
		while (true) {
			try {
				System.out.print("Entrez la coordonnée X: ");
				portX = Integer.parseInt(scanner.nextLine());
				System.out.println();
				System.out.print("Entrez la la coordonnée Y: ");
				portY = Integer.parseInt(scanner.nextLine());

				if (portX <= width && portY <= height) {
					break;
				} else {
					System.out.println("La coordonnée X doit être inférieur ou égale à " + width + " et la coordonnée Y doit être inférieur ou égale à " + height +".");
				}
			} catch (NumberFormatException e) {
				System.out.println("Veuillez entrer des nombres valides.");
			}
		}
		
		System.out.println();
      Tuile tuilePort = ares.getPlateau().getTuile(portX, portY);
		action.construirePort(tuilePort);

      System.out.println();
      System.out.println();
      System.out.println("----> " + player.getName() + ": " + player.getRessources() + " (" + player.getWarriorsStock() + " warriors) échange des ressources.");

      System.out.println();

		System.out.println("Ressources disponibles: " + player.getRessources());

		System.out.println();

      System.out.print("Choisit une ressource à échanger: \n");
		System.out.println("1: Moutons");
		System.out.println("2: Minerai");
		System.out.println("3: Blé");
		System.out.println("4: Bois");

		System.out.println();

      // System.out.println("Ressource à échanger: ");
		// int ressourceEchangeeViaPort = Integer.parseInt(scanner.nextLine());

		// System.out.println();

		// System.out.print("Ressource à acquérir: ");
		// int ressourceAcquieViaPort = Integer.parseInt(scanner.nextLine());

		// System.out.println();

		action.echangerRessources(1, Ressource.Bois, Ressource.Bois);

      System.out.println();
      System.out.println();

      System.out.println("----> " + player.getName() + ": " + player.getRessources() + " (" + player.getWarriorsStock() + " warriors) achète une arme secrète.");

      System.out.println();

      action.acheterArmeSecrete();

      System.out.println();

      System.out.println("----> liste des bâtiments en sa possession");

      System.out.println();

		System.out.println(player.getDisplayBatiments());

		System.out.println();
		System.out.println();

		System.out.println("----> liste des tuiles occupées");

      System.out.println();
      
		System.out.println(player.getDisplayTuilesPossedes());


      scanner.close();
      // Affichage dans une fenêtre Swing
      PlateauSwing.afficherPlateau(ares.getPlateau());

   }
}










