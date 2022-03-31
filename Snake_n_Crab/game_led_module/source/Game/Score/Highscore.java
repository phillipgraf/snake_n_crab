package Game.Score;

public class Highscore {

    private int highscore;


    public void printH(){
        System.out.println("Der aktuelle Highscore liegt bei: " + highscore);
    }

    public int getH() {
        return highscore;
    }

    public void setH(int highscore) {
        this.highscore = highscore;
    }
}
