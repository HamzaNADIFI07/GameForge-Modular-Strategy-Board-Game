package game;

import java.util.HashMap;
import java.util.Map;

import ressource.Ressource;

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
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    }

