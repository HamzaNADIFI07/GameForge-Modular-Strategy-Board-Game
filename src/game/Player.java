package game;
import java.util.List;
import java.util.Map;

public class Player {
	private String name;
    private int score;
    private List<String> resources;
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
    public void updateScore(int points) {
        score += points;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public int getScore() {
    	return score;
    }
    public void setScore(int score) {
    	this.score = score;    
    }

    /*je pense qu'on doit ajouter ces methodes si nécessaire*/
    public boolean hasResource(String resource, int quantity) {
        return resources.contains(resource);
    }

    public void addResource(String resource) {
        resources.add(resource);
    }

    public void removeResource(String resource) {
        resources.remove(resource);
    }
    public void useResources(String resourceToGive, int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useResources'");
    }
    public boolean hasResources(String string, int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasResources'");
    }
    public void buySecretWeapon() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buySecretWeapon'");
    }
    public void addWarriorsToStock(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addWarriorsToStock'");
    }
    public void buildArmy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buildArmy'");
    }
    public void buildPort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buildPort'");
    }
    public void replaceArmyWithCamp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replaceArmyWithCamp'");
    }
    public boolean hasWarriorsInStock(int quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasWarriorsInStock'");
    }
    public void positionWarriors(String type, int quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'positionWarriors'");
    }
    public boolean attackNeighbor(Player voisin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attackNeighbor'");
    }
    public void addResources(String resourceToReceive, int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addResources'");
    }
}

