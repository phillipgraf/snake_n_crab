package Game;

public class Main {

    static public void main(String[] Args) throws InterruptedException{

        Karte k = new Karte();

        k.start();

        k.loadObjects();

        k.play();

    }
}
