package plateau;

public class Plateau {
	/**
	 * en attendant la creation de la classe tuile je l'ai mit en commentaire
	 */
	//private Tuilles[][] tuilles ;
	private int x ;
	private int y;
	private int nbMers;
    private int nbChamps;
    private int nbForets;
    private int nbMontagnes;
    private int nbPaturages;
    
        public Plateau(int x, int y) {
            this.x = x;
            this.y = y;
            //this.tuile = new Tuiles[x][y];
            this.nbMers = 0;
            this.nbChamps = 0;
            this.nbForets = 0;
            this.nbMontagnes = 0;
            this.nbPaturages = 0;
        
        }
    }
	

