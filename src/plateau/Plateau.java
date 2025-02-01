package plateau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tuile.Tuile;
import tuile.type_tuile.*;

/**
 * La classe Plateau représente un plateau de jeu composé de tuiles.
 * Elle permet d'initialiser un plateau, de générer des tuiles aléatoires
 * et d'appliquer des contraintes d'adjacence pour les tuiles non Mer
 * avec le respect de la contrainte de 1/3 des tuiles non Mer et 2/3 de tuiles Mer.
 */
public class Plateau {
    private Position[] cardinaux = { new Position(-1, 0), new Position(1, 0), new Position(0, -1), new Position(0, 1) };
    private Tuile[][] tuile;
    private int x;
    private int y;

    /**
     * Constructeur de la classe Plateau.
     * Initialise un plateau de dimensions x par y.
     *
     * @param x la largeur du plateau (nombre de colonnes)
     * @param y la hauteur du plateau (nombre de lignes)
     */
    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
        this.tuile = new Tuile[x][y];
        cons();
    }

    /**
     * Initialise le plateau avec des tuiles respectant la contrainte des couples non Mer.
     */
    public void cons() {
        List<Tuile> listeTuile = this.genereListe();
        for (Tuile t : listeTuile) {
            this.tuile[t.getX()][t.getY()] = t;
        }
    }

    /**
     * Affiche le plateau de jeu dans la console.
     */
    public void display() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                System.out.print((this.tuile[i][j] != null ? this.tuile[i][j].toString() : " ") + " ");
            }
            System.out.println();
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Tuile getTuile(int x, int y) {
        return tuile[x][y];
    }

    /**
     * Classe interne représentant une position (x, y) sur le plateau.
     */
    public class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public String toString() {
            return "(" + this.x + " , " + this.y + ")";
        }

        public boolean equals(Object o) {
            if (!(o instanceof Position)) {
                return false;
            }
            Position other = (Position) o;
            return this.x == other.x && this.y == other.y;
        }

        public Position getNextPosition(Position pos) {
            return new Position(x + pos.x, y + pos.y);
        }
    }

    public List<Position> getCoteCardinaux(Position pos) {
        List<Position> res = new ArrayList<>();
        for (Position position : cardinaux) {
            Position newPos = pos.getNextPosition(position);
            if (this.isValidPosition(newPos) && this.tuile[newPos.getX()][newPos.getY()] == null) {
                res.add(newPos);
            }
        }
        return res;
    }

    public List<Position> getListPosition() {
        List<Position> res = new ArrayList<>();
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                res.add(new Position(i, j));
            }
        }
        return res;
    }

    /**
     * Génère une tuile aléatoire parmi Foret, Paturage, Montagne ou Champ.
     * @return Une tuile non Mer
     */
    public Tuile generTuile() {
        Random val = new Random();
        int n = val.nextInt(4);
        switch (n) {
            case 0: return new Foret(0, 0);
            case 1: return new Paturage(0, 0);
            case 2: return new Montagne(0, 0);
            default: return new Champ(0, 0);
        }
    }

    /**
     * Vérifie si une position donnée est valide sur le plateau.
     * @param pos Position à vérifier
     * @return true si la position est valide, sinon false.
     */
    public boolean isValidPosition(Position pos) {
        return pos.getX() >= 0 && pos.getX() < this.x && pos.getY() >= 0 && pos.getY() < this.y;
    }

    /**
     * Génère une liste de tuiles respectant la contrainte :
     *  - Lorsqu'une tuile non Mer est placée, une autre tuile non Mer est placée à côté.
     * @return Liste des tuiles placées sur le plateau.
     */
    public List<Tuile> genereListe() {
        List<Position> listePos = this.getListPosition();
        Random alea = new Random();
        List<Tuile> res = new ArrayList<>();

        int totalTiles = x * y;
        int nonMerTilesCount = totalTiles / 3; 

        while (nonMerTilesCount > 0 && !listePos.isEmpty()) {
            int index = alea.nextInt(listePos.size());
            Position choix1 = listePos.get(index);
            listePos.remove(index);

            List<Position> voisins = getCoteCardinaux(choix1);
            if (!voisins.isEmpty()) {
                int index2 = alea.nextInt(voisins.size());
                Position choix2 = voisins.get(index2);
                listePos.remove(choix2);

                Tuile t1 = generTuile();
                t1.setX(choix1.getX());
                t1.setY(choix1.getY());

                Tuile t2 = generTuile();
                t2.setX(choix2.getX());
                t2.setY(choix2.getY());

                res.add(t1);
                res.add(t2);
                nonMerTilesCount -= 2;
            }
        }
        for (Position pos : listePos) {
            res.add(new Mer(pos.getX(), pos.getY()));
        }

        return res;
    }
}
