package main;
import batiment.type_batiment.Armee;
import batiment.type_batiment.Camp;
import batiment.type_batiment.Exploitation;
import batiment.type_batiment.Ferme;
import batiment.type_batiment.Port;
import plateau.Plateau;
import tuile.Tuile;
import tuile.type_tuile.Champ;
import tuile.type_tuile.Mer;
import tuile.type_tuile.Paturage;

public class Livrable2 {
	public static void main(String[] args) {
		if (args.length <2) {
			System.out.println("Usage: java Livrable2 <largeur> <longeur>");
			return;
		}
		//test
		int largeur = Math.max(10,Integer.parseInt(args[0]));
		int longeur = Math.max(10,Integer.parseInt(args[1]));
		Plateau plateau = new Plateau(largeur , longeur);
		plateau.genererTuiles();
		plateau.display();
		placerBatiments(plateau);
		
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
	                boolean adjacenteMer = false;

	                //  loop to check for adjacent Mer tiles
	                for (Tuile adj : tuile.getAdjacents()) {
	                    if (adj instanceof Mer) {
	                        adjacenteMer = true;
	                        break; // Stop checking if we find Mer
	                    }
	                }

	                if (port == null && tuile instanceof Champ && adjacenteMer) {
	                    port = new Port(tuile);
	                    System.out.println("Port placé sur (" + tuile.getX() + ", " + tuile.getY() + ")");
	                } else if (ferme == null && tuile instanceof Champ) {
	                    ferme = new Ferme(tuile);
	                    System.out.println("Ferme placée sur (" + tuile.getX() + ", " + tuile.getY() + ")");
	                } else if (exploitation == null && tuile instanceof Paturage) {
	                    exploitation = new Exploitation(tuile);
	                    System.out.println("Exploitation placée sur (" + tuile.getX() + ", " + tuile.getY() + ")");
	                } else if (armee == null && !(tuile instanceof Mer)) {
	                	armee = new Armee(tuile, 3);
	                    System.out.println("Armée placée sur (" + tuile.getX() + ", " + tuile.getY() +") avec 3 guerriers");
	                } else if (camp == null && !(tuile instanceof Mer)) {
	                    camp = new Camp(tuile);
	                    System.out.println("Camp placé sur (" + tuile.getX() + ", " + tuile.getY() + ")");
	                }
	            }
	        }
	    }


	}}

