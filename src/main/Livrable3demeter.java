package main;

import batiment.Batiment;
import game.Demeter.Demeter;
import game.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ressource.Ressource;

public class Livrable3demeter {

	public static void main(String[] args) {
		System.out.println();
		System.out.println();
		Scanner scanner = new Scanner(System.in);

		int largeur, longeur;
		while (true) {
			try {
				System.out.print("Entrez la largeur du plateau: ");
				largeur = Integer.parseInt(scanner.nextLine());

				System.out.println();
				System.out.println();

				System.out.print("Entrez la hauteur du plateau: ");
				longeur = Integer.parseInt(scanner.nextLine());

				if (largeur >= 10 && longeur >= 10) {
					break;
				} else {
					System.out.println("Les dimensions doivent être supérieures ou égale à 10.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Veuillez entrer des nombres valides.");
			}
		}
		System.out.println(" -----------------");
		System.out.println("----- DEMETER -----");
		System.out.println(" -----------------");

		System.out.println();
		System.out.println();

		Player player1 = new Player("Leon");
		List<Player> players = new ArrayList<>();
		players.add(player1);

		Demeter demeter = new Demeter(players, largeur, longeur);
		demeter.setCurrentPlayer(player1);

		System.out.println("----> " + player1.getName() + " [ " + player1.getRessources() + " ] veut construire une ferme.");
		System.out.println();
		System.out.println("Où installer une ferme ?");

		int coordonneeX;
		int coordonneeY;
		while (true) {
			try {
				System.out.print("Entrez la coordonnée X: ");
				coordonneeX = Integer.parseInt(scanner.nextLine());
				System.out.println();
				System.out.print("Entrez la la coordonnée Y: ");
				coordonneeY = Integer.parseInt(scanner.nextLine());

				if (coordonneeX <= largeur && coordonneeY <= longeur) {
					break;
				} else {
					System.out.println("La coordonnée X doit être inférieur ou égale à " + largeur + " et la coordonnée Y doit être inférieur ou égale à " + longeur +".");
				}
			} catch (NumberFormatException e) {
				System.out.println("Veuillez entrer des nombres valides.");
			}
		}
		demeter.getAction().construireFerme(coordonneeX, coordonneeY);

		System.out.println();
		System.out.println();
		System.out.println("----> " + player1.getName() + " [ " + player1.getRessources() + " ] veut remplacer une ferme par une exploitation.");
		System.out.println();

		List<String> displayFermes = player1.getDisplayBatimentsParType("Ferme");
		System.out.println("quelle ferme transformer en exploitation ?");
		System.out.println();
		System.out.println(displayFermes.size() + ": " + displayFermes);
		System.out.println();

		int indiceFerme;
		while (true) {
			try {
				System.out.print("Quelle ferme transformer en exploitation ? ");
				indiceFerme = Integer.parseInt(scanner.nextLine());
				if (indiceFerme >= 1 && indiceFerme <= displayFermes.size()) {
					break;
				} else {
					System.out.println("Indice invalide.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Veuillez entrer un nombre valide.");
			}
		}
		List<Batiment> fermes = player1.getBatimentsParType("Ferme");
		demeter.getAction().construireExploitation(fermes.get(indiceFerme - 1).getTuile().getX(), fermes.get(indiceFerme - 1).getTuile().getY());


		System.out.println();
		System.out.println();

		System.out.println("----> " + player1.getName() + " [ " + player1.getRessources() + " ] veut construire un port.");
		
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

				if (portX <= largeur && portY <= longeur) {
					break;
				} else {
					System.out.println("La coordonnée X doit être inférieur ou égale à " + largeur + " et la coordonnée Y doit être inférieur ou égale à " + longeur +".");
				}
			} catch (NumberFormatException e) {
				System.out.println("Veuillez entrer des nombres valides.");
			}
		}
		
		System.out.println();

		demeter.getAction().construirePort(portX, portY);
		
		System.out.println();
		System.out.println();

		System.out.println("----> " + player1.getName() + " [ " + player1.getRessources() + " ] veut échanger des ressources sans se servir du port.");

		System.out.println();

		System.out.println("Ressources disponibles: " + player1.getRessources());

		System.out.println();

		System.out.print("Choisit une ressource à échanger: \n");
		System.out.println("1: Moutons");
		System.out.println("2: Minerai");
		System.out.println("3: Blé");
		System.out.println("4: Bois");

		System.out.println();

		// System.out.println("Ressource à échanger: ");
		// int ressourceEchangee = Integer.parseInt(scanner.nextLine());

		// System.out.println();

		// System.out.print("Ressource à acquérir: ");
		// int ressourceAcquie = Integer.parseInt(scanner.nextLine());

		System.out.println();

		demeter.getAction().echangerRessources(1, Ressource.Ble, Ressource.Minerai, false);

		System.out.println();
		System.out.println();

		System.out.println("----> " + player1.getName() + " [ " + player1.getRessources() + " ] veut échanger des ressources grâce à son port.");

		System.out.println();

		System.out.println("Ressources disponibles: " + player1.getRessources());

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

		demeter.getAction().echangerRessources(1, Ressource.Bois, Ressource.Bois, true);

		System.out.println();
		System.out.println();

		System.out.println("----> " + player1.getName() + " [ " + player1.getRessources() + " ] veut acheter un voleur.");
		System.out.println();
		demeter.getAction().acheterVoleur();

		System.out.println();
		System.out.println();

		System.out.println("----> " + player1.getName() + " [ " + player1.getRessources() + " ].");		
		System.out.println(player1.getRessources());

		System.out.println();
		System.out.println();

		System.out.println("----> liste des bâtiments en sa possession");
		System.out.println(player1.getDisplayBatiments());

		System.out.println();
		System.out.println();

		System.out.println("----> liste des tuiles occupées");
		System.out.println(player1.getDisplayTuilesPossedes());



		// Affichage dans une fenêtre Swing
        PlateauSwing.afficherPlateau(demeter.getPlateau());
		scanner.close();
	
	}
}
