package Game.Score;

public class Score {

    private int score = 1;

    public void printS(){
        System.out.println("Dein aktuelle Spielstand ist: " + score);
    }

    //add Points to score
    public void addPToS(int scorePoints){
       score = score + scorePoints;
    }

    public void setS(int score) {
        this.score = score;
    }

    public int getS() {
        return score;
    }
}
