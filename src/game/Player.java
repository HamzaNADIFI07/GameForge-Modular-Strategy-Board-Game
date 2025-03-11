package game;

import java.util.HashMap;
import java.util.Map;

import batiment.Batiment;
import ressource.Ressource;
import tuile.Tuile;

public class Player {
	private String name;
	private Map<Ressource, Integer> ressources;
	private int warriors;
	private boolean hasSecretWeapon;
    
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
    }

