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

}
