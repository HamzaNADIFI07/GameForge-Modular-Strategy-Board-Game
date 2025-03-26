package game;

import batiment.Batiment;
import batiment.type_batiment.Armee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ressource.Ressource;
import tuile.Tuile;


/**
 * Représente un joueur dans le jeu.
 *
 * Cette classe gère les informations et les actions associées à un joueur, telles que les ressources,
 * les bâtiments possédés, les guerriers, les tuiles contrôlées et les échanges de ressources.
 * 
 */
public class Player {
	/** Nom du joueur. */
	private String name;
	/** Stock des ressources du joueur. */
	private Map<Ressource, Integer> ressources;
	/** Nombre de guerriers disponibles. */
	private int warriors;
	/** Indique si le joueur possède une arme secrète. */
	private boolean hasSecretWeapon;
	/** Liste des bâtiments possédés par le joueur. */
	private List<Batiment> batimentsPossedes = new ArrayList<>();
	/** Liste des tuiles contrôlées par le joueur. */
	private List<Tuile> tuilesPossedes = new ArrayList<>();
	/** Indique le nombre de ports possédés par le joueur. */
	private int port;
	/** Indique le nombre de voleurs possédés par le joueur. */
	private int voleur;
    
	/**
     * Constructeur pour créer un nouveau joueur avec un nom donné.
     * Initialise chaque ressource à 10 unités, aucun guerrier et aucune arme secrète.
     *
     * @param name Le nom du joueur
     */
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

	/**
     * Renvoie le nombre de ports possédés par le joueur.
     *
     * @return Nombre de ports.
     */
    public int getPort() {
		return port;
	}

	/**
     * Définit le nombre de ports du joueur.
     *
     * @param port Nombre de ports.
     */
	public void setPort(int port) {
		this.port = port;
	}

	/**
     * Renvoie les tuiles possédées par le joueur.
     *
     * @return Liste des tuiles.
     */
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
	
	/**
     * Définit la liste des tuiles possédées par le joueur.
     *
     * @param tuilesPossedes Liste des nouvelles tuiles possédées.
     */
	public void setTuilesPossedes(List<Tuile> tuilesPossedes) {
		this.tuilesPossedes = tuilesPossedes;
	}

	/**
     * Vérifie si une tuile est possédée par le joueur.
     *
     * @param tuile Tuile à vérifier.
     * @return true si la tuile est possédée, sinon false.
     */
	public boolean possedeTuile(Tuile tuile) {
		return tuilesPossedes.contains(tuile);
	}
	/**
     * Ajoute une tuile aux possessions du joueur.
     *
     * @param tuile Tuile à ajouter.
     */
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

	/**
     * Renvoie le nom du joueur.
     *
     * @return Nom du joueur.
     */
    public String getName() {
    	return name;
    }
	/**
     * Modifie le nom du joueur.
     *
     * @param name Nouveau nom.
     */
    public void setName(String name) {
    	this.name = name;
    }

	/**
     * Affiche les ressources actuelles du joueur.
     */
    public void afficherRessources() {
        System.out.println(name + ": " + this.ressources);
    }

	/**
     * Vérifie si le joueur possède suffisamment d'une certaine ressource.
     *
     * @param resource Ressource à vérifier.
     * @param amount Quantité nécessaire.
     * @return true si la ressource est suffisante, sinon false.
     */
    public boolean hasResources(Ressource resource, int amount) {
    	return this.ressources.getOrDefault(resource, 0) >= amount;
    }
    public boolean hasWarriorsInStock(int amount) {
    	return this.warriors >= amount;
    }

	/**
     * Consomme une certaine quantité d'une ressource.
     *
     * @param resource Ressource à consommer.
     * @param amount Quantité à consommer.
     * @return true si réussi, sinon false.
     */
    public boolean useResources(Ressource resource, int amount) {
    	if (!hasResources(resource, amount)) {
    		System.out.println("Ressources insuffisantes pour " + resource);
    		return false;
    	}
    	this.ressources.put(resource, this.ressources.get(resource) - amount);
    	return true;
    }

	/**
     * Construit une armée sur une tuile donnée.
     *
     * @param t Tuile sur laquelle construire l'armée.
     */
    public void buildArmy(Tuile t) {
    	if (hasResources(Ressource.Bois, 1) && hasResources(Ressource.Moutons, 1) && hasResources(Ressource.Ble, 1) && hasWarriorsInStock(1)) {
    		useResources(Ressource.Bois, 1);
    		useResources(Ressource.Moutons, 1);
    		useResources(Ressource.Ble, 1);
    		warriors--;
    		Armee armee = new Armee(t, 1);
    		t.setBatiment(armee);
    	} else {
    		System.out.println("Construction d'armée impossible: ressources ou guerriers insuffisants.");
    	}
    }
	/**
     * Ajoute une quantité de guerriers au stock du joueur.
     *
     * @param amount Quantité de guerriers à ajouter.
     */
    public void addWarriors(int amount) {
    	this.warriors += amount;
    }

	/**
     * Permet d'acheter une arme secrète.
     */
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

	/**
     * Lance une attaque contre un joueur voisin.
     *
     * @param voisin Joueur à attaquer.
     * @return true si l'attaque réussit, sinon false.
     */
    public boolean attackNeighbor(Player voisin) {
		if (hasWarriorsInStock(1)) {			
			warriors--;
			System.out.println(name + " a attaqué " + voisin.getName() + "!");
			return true;
		} else {
			System.out.println("Attaque impossible : guerriers insuffisants.");
			return false; 
		}
		/* */
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
	/**
     * Renvoie les ressources du joueur.
     *
     * @return Ressources du joueur.
     */
	public Map<Ressource, Integer> getRessources() {
		return ressources;
	}

	/**
     * Permet d'ajouter une quantité positive de ressources au joueur.
     *
     * @param resource Ressource à ajouter.
     * @param quantite Quantité à ajouter.
     */
	public void addRessource(Ressource resource, int quantite) {
    	if (quantite <= 0) {
        	System.out.println("La quantité à ajouter doit être positive.");
        	return;
    	}
    	ressources.put(resource, ressources.getOrDefault(resource, 0) + quantite);
	}

	/**
     * Renvoie le nombre de voleurs possédés par le joueur.
     *
     * @return Nombre de voleurs.
     */
	public int getVoleur() {
		return voleur;
	}

	/**
     * Définit le nombre de voleurs possédés par le joueur.
     *
     * @param voleur Nombre de voleurs.
     */
	public void setVoleur(int voleur) {
		this.voleur = voleur;
	}
	public void useWarriors(int i) {

	
		throw new UnsupportedOperationException("Unimplemented method 'useWarriors'");
	}

	/**
     * Vérifie si le joueur possède une arme secrète.
     *
     * @return true s'il possède une arme secrète, sinon false.
     */
	public boolean isHasSecretWeapon() {
		return hasSecretWeapon;
	}

	/**
     * Définit si le joueur possède une arme secrète ou non.
     *
     * @param hasSecretWeapon Indicateur de possession d'arme secrète.
     */
	public void setHasSecretWeapon(boolean hasSecretWeapon) {
		this.hasSecretWeapon = hasSecretWeapon;
	}
	/**
	 * Renvoie le nombre de guerriers actuellement en stock.
	 *
	 * @return nombre de guerriers
	 */
	public int getWarriorsStock() {
	    return this.warriors;
	}

	public void setWarriors(int warriors) {
		this.warriors = warriors;
	}


    public void positionWarriorsInArmy(int quantity) { 
		if (quantity <= 0) {
			System.out.println("La quantité doit être positive.");
			return;
		}
		if (quantity > this.warriors) {
			System.out.println("Quantité insuffisante de guerriers en stock.");
			return;
		}
		this.warriors -= quantity;
		System.out.println(quantity + " guerriers ont été positionnés dans l'armée.");
        
    }
		

    public void positionWarriorsInCamp(int quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'positionWarriorsInCamp'");
    }

}

