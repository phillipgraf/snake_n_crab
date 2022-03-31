package Game;

import Game.GameObjects.Coconut;
import Game.GameObjects.Background;
import Game.GameObjects.Crab;
import Game.GameObjects.Snake;
import Game.Score.Highscore;
import Game.Score.Score;
import de.thdeg.game.runtime.InternalLedGameThread;

import java.util.LinkedList;

public class Karte {

    private final short[] myImage = new short[24 * 48 * 3];

    //Keyboard variable
    private int thisKey;

    //Objects
    Snake s;
    Coconut a;
    Coconut b;
    Coconut c;
    Crab f;
    Background ba;
    Score sc;
    Highscore hsc;

    //Game variables
    private int sleep = 18;
    private int laufvariable;

    //Snake tail
    private LinkedList<Integer> Schwanz_ypos = new LinkedList<>();
    private LinkedList<Integer> Schwanz_xpos = new LinkedList<>();

    //Koordinaten Positionen des Schlangen Schwanzes
    private int p_y = 0;
    private int p_x = 0;

    //start the game
    public void start() throws InterruptedException{
        // This is initialization, do not change this
        InternalLedGameThread.run();
        // Now we show some introductory message and wait 3s before we switch to purple
        System.out.println("Please wait for three seconds until the LED shows purple color, then you can use the cursor keys in order to move a green dot over the LED display");
        Thread.sleep(3000); //VORHER 3000ms
    }

    public void loadObjects() {
        a = new Coconut();
        b = new Coconut();
        c = new Coconut();
        f = new Crab();
        ba = new Background();
        s = new Snake();

        sc = new Score();
        hsc = new Highscore();
    }

        //set the background
       public void paintthepanel() {
        ba.fillMap(ba.getXpos(),ba.getYpos(),0,120,200,myImage);
        ba.setColour(ba.getYpos(), ba.getXpos(), ba.getRed_value(), ba.getGreen_value(), ba.getBlue_value(), myImage);
        ba.zahlen(255, 255, 255, sc.getS(), myImage);
        ba.setColour(a.getYpos(), a.getXpos(), a.getRed_value(), a.getGreen_value(), a.getBlue_value(), myImage);
        ba.setColour(b.getYpos(), b.getXpos(), b.getRed_value(), b.getGreen_value(), b.getBlue_value(), myImage);
        ba.setColour(c.getYpos(), c.getXpos(), c.getRed_value(), c.getGreen_value(), c.getBlue_value(), myImage);
        ba.setColour(f.getYpos(), f.getXpos(), f.getRed_value(), f.getGreen_value(), f.getBlue_value(), myImage);
        ba.setColour(s.getYpos(), s.getXpos(), s.getRed_value(), s.getGreen_value(), s.getBlue_value(), myImage);
        showImage();
        }

    public void resetApple_a() {
            a = new Coconut();
    }

    public void resetApple_b() {
            b = new Coconut();
    }

    public void resetApple_c() {
            c = new Coconut();
    }


    public void resetCrab(){
        if ((f.getYpos() == a.getYpos() && f.getXpos() == a.getXpos()) || (f.getYpos() == b.getYpos() && f.getXpos() == b.getXpos()) || (f.getYpos() == c.getYpos() && f.getXpos() == c.getXpos())) {
            resetCrab();
        }
         else
            f = new Crab();
    }


    public void resetSnake(){
        s.setYpos(12);
        s.setXpos(22);
        p_y = 0;
        p_x = 0;
        s.setSpeedS(13);

        System.out.println();
        System.out.println("Hey du bist gerade gestorben. Du hast ein Score von " + sc.getS() + " erreicht!");
        if(sc.getS() > hsc.getH()){
            System.out.println("Damit hast du so eben den Highscore von: " + hsc.getH() + " geknackt!");
            hsc.setH(sc.getS());
            hsc.printH();
        }
        else {
            hsc.printH();
            System.out.println("Probiers doch gleich nochmal! :D");
        }
        System.out.println();

        sc.setS(1);

    }

    public void play() throws InterruptedException {

        while (true) {
            thisKey = InternalLedGameThread.getKeyboard();

            //Richtung der Schlange
            s.setRichtung(thisKey);

            // Aktion wenn Schlange Apfel frisst
            // !!!!!!!!!!!!
            if (s.getYpos() == a.getYpos() && s.getXpos() == a.getXpos()) {
                eat(-1, 1);
                resetApple_a();
            } else if (s.getYpos() == b.getYpos() && s.getXpos() == b.getXpos()) {
                eat(-1, 1);
                resetApple_b();
            } else if (s.getYpos() == c.getYpos() && s.getXpos() == c.getXpos()) {
                eat(-1, 1);
                resetApple_c();
            }

            //Aktion der Schlange, wenn Fliege frisst
            if (s.getYpos() == f.getYpos() && s.getXpos() == f.getXpos()) {
                eat(2, 1);
                resetCrab();
            }

            //Geschwindigkeit der Schlange
            if(laufvariable % s.getSpeedS() == 0) {

                //Gibt neues Bild aus
                paintthepanel();

                //Malt den Schlangenschwanz
                Schwanz_ypos.addFirst(s.getYpos());
                Schwanz_xpos.addFirst(s.getXpos());
                for (int y = 1, x = 1; p_y >= y && p_x >= x; y++, x++) {
                    ba.setColour(Schwanz_ypos.get(y), Schwanz_xpos.get(x), 0, 200, 0, myImage);
                }
                showImage();

                //Bewegt Schlange in Richtung
                s.moveSnake();

            }

            //Geschwindigkeit des Spiel
            Thread.sleep(sleep);

            //Noahs Laufvariable
            laufvariable++;

            //Fliege
            f.moveCrab(laufvariable);
            for (int y = 0, x = 0; p_y >= y && p_x >= x; y++, x++) {
                f.hitCrab(Schwanz_ypos.get(y), Schwanz_xpos.get(x));
            }

            //Setzt die Schlange zurück bei  Berührung mit Wand
            if ((s.getYpos() == 0 || s.getYpos() == 23 || s.getXpos() == 0 || s.getXpos() == 47)) {
                resetSnake();
            }

            //Schlange frisst sich selber
            for (int y = 0, x = 0; p_y >= y && p_x >= x; y++, x++) {

                if (s.getYpos() == Schwanz_ypos.get(y) && s.getXpos() == Schwanz_xpos.get(x)) {
                    resetSnake();
                }
            }

        }
    }

    public void showImage (){
            InternalLedGameThread.showImage(myImage);
    }

    public void eat (int speed, int scorepoints){

        p_y++;
        p_x++;

        if(s.getSpeedS() == 1){
            s.setSpeedS(2);
        }
        s.setSpeedS(s.getSpeedS() + speed);

        sc.addPToS(scorepoints);
        sc.printS();

    }

}