package plateau;

import game.Player;
import java.util.*;
import tuile.Tuile;
import tuile.type_tuile.Champ;
import tuile.type_tuile.Foret;
import tuile.type_tuile.Mer;
import tuile.type_tuile.Montagne;
import tuile.type_tuile.Paturage;

/**
 * La classe Plateau représente un plateau de jeu composé de tuiles.
 * Elle permet d'initialiser un plateau, de générer des tuiles aléatoires
 * et d'appliquer des contraintes d'adjacence pour les tuiles non Mer 
 * avec le respect de la contrainte de 1/3 des tuile non Mer et 2/3 de tuile Mer
 */
public class Plateau {
	private final Tuile[][] tuile ;
	private final int x ;
	private final int y;



    /**
     * Constructeur de la classe Plateau.
     * Initialise un plateau de dimensions x par y, avec uniquement des tuiles de type Mer.
     * 
     * @param x la largeur du plateau (nombre de colonnes)
     * @param y la hauteur du plateau (nombre de lignes)
     */
    
    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
        this.tuile = new Tuile[x][y];
        initialiserPlateau();
        genererTuiles();
        display();
    
    }

    /**
     * Initialise le plateau avec des tuiles de type Mer.
     */
    
    private void initialiserPlateau() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                tuile[i][j] = new Mer(i,j);
            }
        }
    }

    /**
     * Génère aléatoirement les tuiles du plateau en respectant une contrainte 
     * de proportion : 1/3 des tuiles sont non-Mer, et 2/3 sont des tuiles de type Mer.
     */

    public void genererTuiles() {

        Random random = new Random();

        int nombreNonMer = (int) ((this.x * this.y) * (1.0 / 3.0));
        int tuilesNonMerPlacees = 0;

        // Boucle avec condition qui vérifie la contrainte de 1/3 Tuile Non Mer et 2/3 Tuile Mer
        while (tuilesNonMerPlacees < nombreNonMer) {
            int randomX = random.nextInt(this.x);
            int randomY = random.nextInt(this.y);

            // Vérifie que la case est encore Mer pour ne pas recréer une tuile non Mer sur une tuile qui est déjà non Mer
            if (tuile[randomX][randomY] instanceof Mer) {
                // Place une tuile non-marine aléatoire
                tuile[randomX][randomY] = genererTuileNonMerAleatoire(randomX,randomY);
                tuilesNonMerPlacees++;
            }
        }
        ajusterContraintesAdjacentes();
    }

    /**
     * Génère une tuile non Mer aléatoirement.
     * 
     * @param x la coordonnée en x de la tuile
     * @param y la coordonnée en y de la tuile
     * @return une tuile non Mer aléatoire
     */
    private Tuile genererTuileNonMerAleatoire(int x,int y) {
        Random random = new Random();
    
        Tuile[] tuilesNonMer = {
            new Champ(x,y),
            new Foret(x,y),
            new Montagne(x,y),
            new Paturage(x,y)
        };
        return tuilesNonMer[random.nextInt(tuilesNonMer.length)];
    }




    /**
     * Ajuste les contraintes d'adjacence pour les tuiles non Mer.
     * Assure qu'aucune tuile non Mer n'est isolée sans tuile adjacente non Mer.
     */
    private void ajusterContraintesAdjacentes() {
        Random random = new Random();

        int totalTuilesNonMarines = getNbTuilesNonMer();
        int nombreMaxTuilesNonMarines = (int) Math.floor((this.x * this.y) * (1.0 / 3.0)); // Un tiers du plateau
    
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                // Si la tuile est non marine et qu'elle n'a pas de tuile non marine adjacente
                if (!(tuile[i][j] instanceof Mer) && !aUneTuileAdjacenteNonMer(i, j)) {
                    // Si ajouter une tuile non marine adjacente dépasse la limite du nombre total
                    if (totalTuilesNonMarines >= nombreMaxTuilesNonMarines) {
                        // Remplacer la tuile isolée par une tuile marine
                        tuile[i][j] = new Mer(i,j);
                    } else {
                        // Récupère les positions adjacentes marines
                        List<int[]> adjacentesMarines = getPositionsAdjacentesMarines(i, j);
    
                        if (!adjacentesMarines.isEmpty()) {
                            // Sélectionne une position adjacente aléatoire
                            int[] position = adjacentesMarines.get(random.nextInt(adjacentesMarines.size()));
                            int adjacenteX = position[0];
                            int adjacenteY = position[1];
    
                            // Place une nouvelle tuile non marine aléatoire sur cette position
                            tuile[adjacenteX][adjacenteY] = genererTuileNonMerAleatoire(adjacenteX , adjacenteY);
                            totalTuilesNonMarines++; // Mise à jour du compteur de tuiles non marines
                        }
                    }
                }
            }
        }
    }

    /**
     * Compte le nombre de tuiles non Mer sur le plateau.
     * 
     * @return le nombre de tuiles non Mer
     */
    public int getNbTuilesNonMer() {
        int count = 0;
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                if (!(tuile[i][j] instanceof Mer)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Compte le nombre de tuiles Mer sur le plateau.
     * 
     * @return le nombre de tuiles Mer
     */
    public int getNbTuilesMer() {
        int count = 0;
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                if ((tuile[i][j] instanceof Mer)) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * Récupère les positions adjacentes contenant des tuiles Mer.
     * 
     * @param x la coordonnée en x de la tuile
     * @param y la coordonnée en y de la tuile
     * @return une liste des positions adjacentes contenant des tuiles marines
     */
    public List<int[]> getPositionsAdjacentesMarines(int x, int y) {
        List<int[]> positions = new ArrayList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Gauche, Droite, Bas, Haut

        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];
            if (newX >= 0 && newX < this.x && newY >= 0 && newY < this.y) {
                if (tuile[newX][newY] instanceof Mer) {
                    positions.add(new int[]{newX, newY});
                }
            }
        }
        return positions;
    }

    /**
     * Vérifie si une tuile a au moins une tuile adjacente non Mer.
     * 
     * @param x la coordonnée en x de la tuile
     * @param y la coordonnée en y de la tuile
     * @return true si la tuile a une tuile adjacente non-Mer, sinon false
     */
    public boolean aUneTuileAdjacenteNonMer(int x, int y) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Gauche, Droite, Bas, Haut
    
        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];
            if (newX >= 0 && newX < this.x && newY >= 0 && newY < this.y) {
                if (!(tuile[newX][newY] instanceof Mer)) {
                    return true; // Une tuile non Mer adjacente a été trouvée
                }
            }
        }
        return false; // Aucune tuile non Mer adjacente trouvée
    }

    /**
     * Vérifie si une tuile a au moins une tuile adjacente Mer.
     * 
     * @param x la coordonnée en x de la tuile
     * @param y la coordonnée en y de la tuile
     * @return true si la tuile a une tuile adjacente Mer, sinon false
     */
    public boolean aUneTuileAdjacenteMer(int x, int y) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Gauche, Droite, Bas, Haut
    
        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];
            if (newX >= 0 && newX < this.x && newY >= 0 && newY < this.y) {
                if ((tuile[newX][newY] instanceof Mer)) {
                    return true; // Une tuile Mer adjacente a été trouvée
                }
            }
        }
        return false; // Aucune tuile Mer adjacente trouvée
    }

    

    /**
     * Affiche le plateau de jeu dans la console.
     */
    public void display() {
        // Ligne supérieure
        System.out.print("   ");
        for (int j = 0; j < this.x; j++) {
            // La condition permet de gérer le décalage des indice quand l'indice dépace 9 donc il devient un nombre à deux chiffre, on enlève un espace pour avoir chqaue indice bien aligner avec la colonne dédié
            if (j<10) {
                System.out.print("   " + j + "  ");
            }
            else{
                System.out.print("  " + j + "  ");
            }
        }
        System.out.println();
        
        // Bordure supérieure de chaque ligne
        System.out.print("   ");
        for (int j = 0; j < this.x; j++) {
            System.out.print("+-----");
        }
        System.out.println("+");
    
        // Contenu du plateau
        for (int i = 0; i < this.y; i++) {
            System.out.printf("%2d ", i);// Affiche le numéro de ligne avec un décalage
            for (int j = 0; j < this.x; j++) {
                if ("Mer".equals(tuile[j][i].getType()) || "Montagne".equals(tuile[j][i].getType())) {
                    System.out.print("| " + tuile[j][i].getType().charAt(0)+ tuile[j][i].getType().charAt(1) + "  ");//affiche la première et deuxième lettre des types des tuiles Mer et Montagne vu que les deux commencent par M, donc pour éviter la confusions entre les deux on affiche les deux premières carctères de leur types
                }
                else{
                    System.out.print("|  " + tuile[j][i].getType().charAt(0) + "  ");//affiche la première lettre de chaque type de tuile
                }
            }
            System.out.println("|");
    
            // Bordure inférieure de chaque ligne
            System.out.print("   ");
            for (int j = 0; j < this.x; j++) {
                System.out.print("+-----");
            }
            System.out.println("+");
        }
    }
    /**
     * Retourne la largeur du plateau.
     */
    public int getX() {
        return this.x;
    }
    /**
     * Retourne la hauteur du plateau.
     */
    public int getY() {
        return this.y;
    }
    /**
     * Retourne la tuile à la position (x, y).
     * 
     * @param x la coordonnée en x de la tuile
     * @param y la coordonnée en y de la tuile
     * @return la tuile à la position (x, y)
     */
    public Tuile getTuile(int x, int y) {
        return tuile[x][y];
    }
    /**
     * Retourne toutes les tuiles du plateau.
     */
    public Tuile[][] getTuiles() {
        return this.tuile;
    }


public int getNombreIlesOccupe(Player joueur) {
    boolean[][] visited = new boolean[this.x][this.y];
    int count = 0;

    for (int i = 0; i < this.x; i++) {
        for (int j = 0; j < this.y; j++) {
            if (!visited[i][j] && !(tuile[i][j] instanceof Mer)) {
                boolean islandHasPlayerBuilding = ileExplore(i, j, visited, joueur);
                if (islandHasPlayerBuilding) {
                    count++;
                }
            }
        }
    }
    return count;
}

private boolean ileExplore(int startX, int startY, boolean[][] visited, Player joueur) {
    boolean occupied = false;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startX, startY});
    visited[startX][startY] = true;

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while (!queue.isEmpty()) {
        int[] pos = queue.poll();
        int x = pos[0];
        int y = pos[1];
        Tuile t = tuile[x][y];

        if (t.getBatiment() != null && joueur.equals(t.getBatiment().getPlayer())) {
            occupied = true;
        }

        for (int[] d : directions) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < this.x && ny >= 0 && ny < this.y && !visited[nx][ny] && !(tuile[nx][ny] instanceof Mer)) {
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    return occupied;
}

    public void afficherTuilesDisponibles() {
        System.out.println("Tuiles disponibles (sans bâtiment) :");
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                Tuile t = this.tuile[i][j];
                if (t.getBatiment() == null && !t.getType().equals("Mer")) {
                    t.display();
                }
            }
        }
    }


}
	

