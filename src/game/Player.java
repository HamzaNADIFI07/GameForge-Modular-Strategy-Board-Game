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
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    }

