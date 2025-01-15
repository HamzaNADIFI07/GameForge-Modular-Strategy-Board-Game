package ressource;

public class Ressource {
	 private String type;
	 private int quantite;

	    public Ressource(String type, int quantite) {
	        this.type = type;
	        this.quantite = quantite;
	    }

	    public String getType() {
	        return type;
	    }

	    public int getQuantite() {
	        return quantite;
	    }


}
