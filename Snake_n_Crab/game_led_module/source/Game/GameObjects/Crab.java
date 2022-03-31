package Game.GameObjects;

public class Crab extends Objects {

    //Richtung der Krabbe
    private int richtungC;
    //Speed Crab
    private int speedC = 25;

    public Crab() {
        super((int) (Math.random() * 22) + 1, (int) (Math.random() * 46) + 1, 255, 60, 0);
    }

    public void moveCrab(int laufvariable) {

        //Geschwindigkeit der Fliege
        richtungC = (int) (Math.random() * 4);

        if (laufvariable % speedC == 0) {

            //Bewegt die Fliege
            switch (richtungC) {
                case 0:
                    setYpos(getYpos() - 1);
                    //Fliege trifft auf Wand
                    if (getYpos() == 0 || getYpos() == 23 || getXpos() == 0 || getXpos() == 47) {
                        setYpos(getYpos() + 1);
                    }
                    break;
                case 1:
                    setYpos(getYpos() + 1);
                    if (getYpos() == 0 || getYpos() == 23 || getXpos() == 0 || getXpos() == 47) {
                        setYpos(getYpos() - 1);
                    }
                    break;
                case 2:
                    setXpos(getXpos() - 1);
                    if (getYpos() == 0 || getYpos() == 23 || getXpos() == 0 || getXpos() == 47) {
                        setXpos(getXpos() + 1);
                    }
                    break;
                case 3:
                    setXpos(getXpos() + 1);
                    if (getYpos() == 0 || getYpos() == 23 || getXpos() == 0 || getXpos() == 47) {
                        setXpos(getXpos() - 1);
                    }
                    break;
            }
        }
    }

    public void hitCrab(int y, int x) {
        switch (richtungC) {
            case 0:
                if (getYpos() == y && getXpos() == x) {
                    setYpos(getYpos() + 1);
                }
            case 1:
                if (getYpos() == y && getXpos() == x) {
                    setYpos(getYpos() - 1);
                }
            case 2:
                if (getYpos() == y && getXpos() == x) {
                    setXpos(getXpos() + 1);
                }
            case 3:
                if (getYpos() == y && getXpos() == x) {
                    setXpos(getXpos() - 1);
                }
        }
    }
}