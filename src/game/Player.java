package game;

import batiment.Batiment;
import batiment.type_batiment.Armee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ressource.Ressource;
import tuile.Tuile;

public class Player {
	private String name;
	private Map<Ressource, Integer> ressources;
	private int warriors;
	private boolean hasSecretWeapon;
	private List<Batiment> batimentsPossedes = new ArrayList<>();
	private List<Tuile> tuilesPossedes = new ArrayList<>();
	private int port;
	private int voleur;
    
	//Ce constructeur initialise un joueur avec un nom, 
	//lui donne 10 unités de chaque ressource, définit 
	//son nombre de guerriers à 0 et indique qu'il ne possède pas d'arme secrète.
    public Player(String name) {
        this.name = name;
        this.ressources = new HashMap<>();
        for (Ressource r : Ressource.values()) {
        	this.ressources.put(r, 10);
        }
        this.warriors = 0;
        this.hasSecretWeapon = false;
        this.port = 0;
		this.voleur = 0;
    }
    public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public List<Tuile> getTuilesPossedes() {
		return tuilesPossedes;
	}

	public List<String> getDisplayTuilesPossedes() {
		List<String> tuilesFiltres = new ArrayList<>();
		for (Tuile t : tuilesPossedes) {
			tuilesFiltres.add(t.display());
		}
		return tuilesFiltres;
	}
	
	public void setTuilesPossedes(List<Tuile> tuilesPossedes) {
		this.tuilesPossedes = tuilesPossedes;
	}
	public boolean possedeTuile(Tuile tuile) {
		return tuilesPossedes.contains(tuile);
	}
	public void addTuile(Tuile tuile) {
		tuilesPossedes.add(tuile);
	}
	/**
     * Permet au joueur de construire un bâtiment sur une tuile donnée,
     * en vérifiant si les ressources nécessaires sont disponibles.
     * 
     * @param b Le bâtiment à construire
     * @param t La tuile sur laquelle construire le bâtiment
     * @return
     */
    public void construireBatiment(Batiment b, Tuile t) {
    	Map<Ressource, Integer> cout = b.getCout();
    	for (Map.Entry<Ressource, Integer> entry : cout.entrySet()) {
    		if (this.ressources.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
    			System.out.println("Ressources insuffisantes pour construire " + b.getType());
    			return;
    		}
    	}
    	for (Map.Entry<Ressource, Integer> entry : cout.entrySet()) {
    		this.ressources.put(entry.getKey(), this.ressources.get(entry.getKey()) - entry.getValue());
    	}
    	t.setBatiment(b);
    	System.out.println(name + " a construit " + b.getType() + " sur " + t);
    }
    /**
     * Permet au joueur d'échanger des ressources, soit via un port (2:1), soit normalement (3:1).
     * 
     * @param nbDonnes Nombre de ressources données
     * @param rDonnee Ressource donnée
     * @param rVoulue Ressource souhaitée
     * @param viaPort Indique si l'échange se fait via un port
     */
    public void echangerRessources(int nbDonnes, Ressource rDonnee, Ressource rVoulue, boolean viaPort) {
    	int ratio = viaPort ? 2 : 3;
    	if (this.ressources.getOrDefault(rDonnee, 0) < nbDonnes || nbDonnes < ratio) {
    		System.out.println("Échange impossible : ressources insuffisantes.");
    		return;
    	}
    	this.ressources.put(rDonnee, this.ressources.get(rDonnee) - nbDonnes);
    	this.ressources.put(rVoulue, this.ressources.getOrDefault(rVoulue, 0) + 1);
    	System.out.println(nbDonnes + " " + rDonnee + " ont été échangés contre 1 " + rVoulue);
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public void afficherRessources() {
        System.out.println(name + ": " + this.ressources);
    }
    public boolean hasResources(Ressource resource, int amount) {
    	return this.ressources.getOrDefault(resource, 0) >= amount;
    }
    public boolean hasWarriorsInStock(int amount) {
    	return this.warriors >= amount;
    }
    public boolean useResources(Ressource resource, int amount) {
    	if (!hasResources(resource, amount)) {
    		System.out.println("Ressources insuffisantes pour " + resource);
    		return false;
    	}
    	this.ressources.put(resource, this.ressources.get(resource) - amount);
    	return true;
    }
    public void buildArmy(Tuile t) {
    	if (hasResources(Ressource.Bois, 1) && hasResources(Ressource.Moutons, 1) && hasResources(Ressource.Ble, 1) && hasWarriorsInStock(1)) {
    		useResources(Ressource.Bois, 1);
    		useResources(Ressource.Moutons, 1);
    		useResources(Ressource.Ble, 1);
    		warriors--;
    		Armee armee = new Armee(t, 1);
    		t.setBatiment(armee);
    		System.out.println(name + " a construit une armée sur " + t);
    	} else {
    		System.out.println("Construction d'armée impossible: ressources ou guerriers insuffisants.");
    	}
    }
    public void addWarriors(int amount) {
    	this.warriors += amount;
    }
    public void buySecretWeapon() {
    	if (hasResources(Ressource.Minerai, 1) && hasResources(Ressource.Bois, 1)) {
    		useResources(Ressource.Minerai, 1);
    		useResources(Ressource.Bois, 1);
    		this.hasSecretWeapon = true;
    		System.out.println(name + " a acheté une arme secrète!");
    	} else {
    		System.out.println("Achat impossible : ressources insuffisantes.");
    	}
    }
    public boolean attackNeighbor(Player voisin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attackNeighbor'");
    }
    public List<Batiment> getBatimentsPossedes() {
		return batimentsPossedes;
	}
	
	public List<String> getDisplayBatimentsParType(String type) {
		List<String> batimentsFiltres = new ArrayList<>();
		int i = 1;
		for (Batiment b : batimentsPossedes) {
			if (b.getType().equalsIgnoreCase(type)) {
				batimentsFiltres.add(i + ": " + b.getType()+" sur "+b.getTuile().display());
				i++;
			}
		}
	
		return batimentsFiltres;
	}

	public List<Batiment> getBatimentsParType(String type) {
		List<Batiment> batimentsFiltres = new ArrayList<>();
		for (Batiment b : batimentsPossedes) {
			if (b.getType().equalsIgnoreCase(type)) {
				batimentsFiltres.add(b);
			}
		}
	
		return batimentsFiltres;
	}

	public List<String> getDisplayBatiments() {
		List<String> batimentsFiltres = new ArrayList<>();
		int i = 1;
		for (Batiment b : batimentsPossedes) {
				batimentsFiltres.add(i + ": " + b.getType()+" sur "+b.getTuile().display());
				i++;
		}
	
		return batimentsFiltres;
	}
	
	public Map<Ressource, Integer> getRessources() {
		return ressources;
	}

	public void addRessource(Ressource resource, int quantite) {
    	if (quantite <= 0) {
        	System.out.println("La quantité à ajouter doit être positive.");
        	return;
    	}
    	ressources.put(resource, ressources.getOrDefault(resource, 0) + quantite);
	}
	public int getVoleur() {
		return voleur;
	}
	public void setVoleur(int voleur) {
		this.voleur = voleur;
	}
	public void useWarriors(int i) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'useWarriors'");
	}

	public boolean isHasSecretWeapon() {
		return hasSecretWeapon;
	}
	public void setHasSecretWeapon(boolean hasSecretWeapon) {
		this.hasSecretWeapon = hasSecretWeapon;
	}

}

