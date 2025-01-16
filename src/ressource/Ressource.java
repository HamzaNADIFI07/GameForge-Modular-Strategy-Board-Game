package ressource;

public abstract class Ressource {
    private String type;

    public Ressource(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}

