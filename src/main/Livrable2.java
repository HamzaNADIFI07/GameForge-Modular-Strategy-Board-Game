package main;
import batiment.type_batiment.Armee;
import batiment.type_batiment.Camp;
import batiment.type_batiment.Exploitation;
import batiment.type_batiment.Ferme;
import batiment.type_batiment.Port;
import java.util.Scanner;
import plateau.Plateau;
import tuile.Tuile;
import tuile.type_tuile.Champ;
import tuile.type_tuile.Mer;
import tuile.type_tuile.Paturage;

public class Livrable2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        int largeur, longeur;
        while (true) {
            try {
                System.out.print("Entrez la largeur du plateau: ");
                largeur = Integer.parseInt(scanner.nextLine());

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
		Plateau plateau = new Plateau(largeur , longeur);
		plateau.genererTuiles();
		plateau.display();
		placerBatiments(plateau);
		afficherRessourcesRecoltees(plateau);
		// Affichage dans une fenêtre Swing
        PlateauSwing.afficherPlateau(plateau);
		scanner.close();
		
	}
	private static void placerBatiments(Plateau plateau) {
	    Tuile[][] tuiles = plateau.getTuiles(); // Récupère toutes les tuiles du plateau

	    Port port = null;
	    Ferme ferme = null;
	    Exploitation exploitation = null;
	    Armee armee = null;
	    Camp camp = null;

	    for (int i = 0; i < tuiles.length; i++) {
	        for (int j = 0; j < tuiles[i].length; j++) {
	            Tuile tuile = tuiles[i][j];

	            // Vérifier si la tuile est libre (pas encore de bâtiment)
	            if (tuile.getBatiment() == null) {
	                boolean adjacenteMer = plateau.aUneTuileAdjacenteMer(i,j);

	                if (port == null && !(tuile instanceof Mer) && adjacenteMer) {
	                    port = new Port(tuile);
						tuile.setBatiment(port);
						tuile.produireRessource();
	                    System.out.println("Port placé sur " + tuile.getType().charAt(0) + "(" + tuile.getX() + ", " + tuile.getY() + ")");
	                } else if (ferme == null && tuile instanceof Champ) {
	                    ferme = new Ferme(tuile);
						tuile.setBatiment(ferme);
						tuile.produireRessource();
	                    System.out.println("Ferme placée sur " + tuile.getType().charAt(0) + "(" + tuile.getX() + ", " + tuile.getY() + ")");
	                } else if (exploitation == null && tuile instanceof Paturage) {
	                    exploitation = new Exploitation(tuile);
						tuile.setBatiment(exploitation);
						tuile.produireRessource();
	                    System.out.println("Exploitation placée sur " + tuile.getType().charAt(0) + "(" + tuile.getX() + ", " + tuile.getY() + ")");
	                } else if (armee == null && !(tuile instanceof Mer)) {
	                	armee = new Armee(tuile, 5);
						tuile.setBatiment(armee);
						tuile.produireRessource();
	                    System.out.println("Armée placée sur " + tuile.getType().charAt(0) + "(" + tuile.getX() + ", " + tuile.getY() +") avec "+ tuile.getBatiment().getDimension() +" guerriers");
	                } else if (camp == null && !(tuile instanceof Mer)) {
	                    camp = new Camp(tuile);
						tuile.setBatiment(camp);
						tuile.produireRessource();
	                    System.out.println("Camp placé sur " + tuile.getType().charAt(0) + "(" + tuile.getX() + ", " + tuile.getY() + ")");
	                }
	            }
	        }
	    }
	 // Affichage des coûts
        System.out.println("\nCoût des bâtiments :");
        System.out.println("Port: " + (port != null ? port.getCout() : "Non placé"));
        System.out.println("Ferme: " + (ferme != null ? ferme.getCout() : "Non placée"));
        System.out.println("Exploitation: " + (exploitation != null ? exploitation.getCout() : "Non placée"));
        System.out.println("Armée: " + (armee != null ? armee.getCout() : "Non placée"));
        System.out.println("Camp: " + (camp != null ? camp.getCout() : "Non placé"));
	}
        private static void afficherRessourcesRecoltees(Plateau plateau) {
            System.out.println("\nRessources récoltées par les bâtiments placés :");
            for (Tuile[] ligne : plateau.getTuiles()) {
                for (Tuile tuile : ligne) {
                    if (tuile.getBatiment() != null) {
                        System.out.println("Tuile (" + tuile.getX() + ", " + tuile.getY() + ") produit : " + tuile.getQuantiteRessource() + " "+ tuile.getRessource());
                    }
                }
            }}}
        
	

