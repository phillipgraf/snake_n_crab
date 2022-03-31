package Game.GameObjects;

public class Snake extends Objects {

    private int richtung = 3;
    //Counter for the Snake speed
    private int cSS;
    //Speed snake
    private int speedS = 13;

    public Snake (){
        super(12, 22, 0, 100, 0);
    }

    public void setRichtung (int thisKey) {

        if (thisKey != -1) {
            switch (thisKey) {
                case 0:
                    if (richtung != 1) {
                        richtung = 0;
                    }
                    break;
                case 1:
                    if (richtung != 0) {
                        richtung = 1;
                    }
                    break;
                case 2:
                    if (richtung != 3) {
                        richtung = 2;
                    }
                    break;
                case 3:
                    if (richtung != 2) {
                        richtung = 3;
                    }
                    break;
            }

        }
    }

        public void moveSnake () {
            switch (richtung) {
                case 0:
                    setYpos(getYpos() - 1);
                    break;
                case 1:
                    setYpos(getYpos() + 1);
                    break;
                case 2:
                    setXpos(getXpos() - 1);
                    break;
                case 3:
                    setXpos(getXpos() + 1);
                    break;
            }
        }

    public int getSpeedS() {
        return speedS;
    }

    public void setSpeedS(int speedS) {
        this.speedS = speedS;
    }
}
