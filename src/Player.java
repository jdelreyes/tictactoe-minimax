public class Player {
    private String name;
    private int score;
    private char playerSymbol;

    public Player(String name, char playerSymbol) {
        this.name = name;
        this.playerSymbol = playerSymbol;
        this.score = 0;
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

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", playerSymbol=" + playerSymbol +
                '}';
    }
}
