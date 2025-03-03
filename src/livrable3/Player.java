package livrable3;

public class Player {
	private String name;
    private int score;
    
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
    }

