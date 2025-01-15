package ressource;

public class Ressource {
	 private String type;
	 private int quantite;

	    public Ressource(String type) {
	        this.type = type;
	        this.quantite = 0;
	    }

	    public String getType() {
	        return type;
	    }

	    public int getQuantite() {
	        return quantite;
	    }


}
