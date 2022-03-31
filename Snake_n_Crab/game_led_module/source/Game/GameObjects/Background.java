package Game.GameObjects;

import Game.GameObjects.Objects;

public class Background extends Objects {

    private int a2;
    private int x1;

    public Background() { super(0, 0, 0, 100, 255);
    }

    //Color a specific dot
    public void setColour(int ypos, int xpos, int red_value, int green_value, int blue_value, short[] myImage) {

        myImage[(ypos * 48 + xpos) * 3 + 0] = (short) red_value;
        myImage[(ypos * 48 + xpos) * 3 + 1] = (short) green_value;
        myImage[(ypos * 48 + xpos) * 3 + 2] = (short) blue_value;
    }

    public void fillMap(int setXpos,int setYpos, int red_value, int green_value, int blue_value, short[] myImage) {

        for (int ypos = 0; ypos < 24; ypos++) {
            for (int xpos = 0; xpos < 48; xpos++)
                setColour(ypos, xpos, 210, 183, 115, myImage);
        }
        //coloring the walls grey
        //left
        for (int ypos = 0; ypos != 24; ypos++) {
            setYpos(ypos);
            setColour(getYpos(), 0, getRed_value(), getGreen_value(), getBlue_value(), myImage);
        }
        //top
        for (int xpos = 0; xpos != 48; xpos++) {
            setXpos(xpos);
            setColour(0, getXpos(), getRed_value(), getGreen_value(), getBlue_value(), myImage);
        }
        //right
        for (int ypos = 0; ypos != 24; ypos++) {
            setYpos(ypos);
            setColour(getYpos(), 47, getRed_value(), getGreen_value(), getBlue_value(), myImage);
        }
        //bottom
        for (int xpos = 0; xpos != 48; xpos++) {
            setXpos(xpos);
            setColour(23, getXpos(), getRed_value(), getGreen_value(), getBlue_value(), myImage);
        }
    }

    public void zahlen(int red_value, int green_value, int blue_value, int getScore, short[] myImage) {

        for (int l = 1; l <= 2; l++) {
            if(l==1){
                a2 = 1;
                x1 = getScore % 10;
            }
            else if(getScore >=10&l==2){
                a2 = -3;
                x1 = (getScore - (getScore % 10)) / 10;
            }

            switch (x1) {
                case 0 -> {
                    for (int i = 2; i <= 6; i++) {
                        setColour(i, 45 + a2, red_value, green_value, blue_value, myImage);
                        setColour(i, 43 + a2, red_value, green_value, blue_value, myImage);
                    }
                    setColour(2, 44 + a2, red_value, green_value, blue_value, myImage);
                    setColour(6, 44 + a2, red_value, green_value, blue_value, myImage);
                }
                case 1 -> {
                    for (int i = 2; i <= 6; i++)
                        setColour(i, 45 + a2, red_value, green_value, blue_value, myImage);
                    setColour(3, 44 + a2, red_value, green_value, blue_value, myImage);
                }
                case 2 -> {
                    for (int i = 43 + a2; i <= 45 + a2; i++) {
                        setColour(2, i, red_value, green_value, blue_value, myImage);
                        setColour(6, i, red_value, green_value, blue_value, myImage);
                    }
                    setColour(3, 45 + a2, red_value, green_value, blue_value, myImage);
                    setColour(4, 44 + a2, red_value, green_value, blue_value, myImage);
                    setColour(5, 43 + a2, red_value, green_value, blue_value, myImage);
                }
                case 3 -> {
                    for (int e = 2; e <= 6; e += 2) {
                        for (int i = 43 + a2; i <= 45 + a2; i++) {
                            setColour(e, i, red_value, green_value, blue_value, myImage);
                        }
                    }
                    setColour(3, 45 + a2, red_value, green_value, blue_value, myImage);
                    setColour(5, 45 + a2, red_value, green_value, blue_value, myImage);
                }
                case 4 -> {
                    for (int i = 2; i <= 6; i++)
                        setColour(i, 45 + a2, red_value, green_value, blue_value, myImage);
                    for (int i = 2; i <= 4; i++)
                        setColour(i, 43 + a2, red_value, green_value, blue_value, myImage);
                    setColour(4, 44 + a2, red_value, green_value, blue_value, myImage);
                }
                case 5 -> {
                    for (int e = 2; e <= 6; e += 2) {
                        for (int i = 43 + a2; i <= 45 + a2; i++) {
                            setColour(e, i, red_value, green_value, blue_value, myImage);
                        }
                    }
                    setColour(5, 45 + a2, red_value, green_value, blue_value, myImage);
                    setColour(3, 43 + a2, red_value, green_value, blue_value, myImage);
                }
                case 6 -> {
                    for (int e = 2; e <= 6; e += 2) {
                        for (int i = 43 + a2; i <= 45 + a2; i++) {
                            setColour(e, i, red_value, green_value, blue_value, myImage);
                        }
                    }
                    setColour(5, 45 + a2, red_value, green_value, blue_value, myImage);
                    setColour(3, 43 + a2, red_value, green_value, blue_value, myImage);
                    setColour(5, 43 + a2, red_value, green_value, blue_value, myImage);
                }
                case 7 -> {
                    for (int i = 43 + a2; i <= 45 + a2; i++)
                        setColour(2, i, red_value, green_value, blue_value, myImage);
                    for (int i = 4; i <= 6; i++)
                        setColour(i, 44 + a2, red_value, green_value, blue_value, myImage);
                    setColour(3, 45 + a2, red_value, green_value, blue_value, myImage);
                }
                case 8 -> {
                    for (int e = 2; e <= 6; e += 2) {
                        for (int i = 43 + a2; i <= 45 + a2; i++) {
                            setColour(e, i, red_value, green_value, blue_value, myImage);
                        }
                    }
                    setColour(5, 45 + a2, red_value, green_value, blue_value, myImage);
                    setColour(3, 43 + a2, red_value, green_value, blue_value, myImage);
                    setColour(5, 43 + a2, red_value, green_value, blue_value, myImage);
                    setColour(3, 45 + a2, red_value, green_value, blue_value, myImage);
                }
                case 9 -> {
                    for (int e = 2; e <= 6; e += 2) {
                        for (int i = 43 + a2; i <= 45 + a2; i++) {
                            setColour(e, i, red_value, green_value, blue_value, myImage);
                        }
                    }
                    setColour(5, 45 + a2, red_value, green_value, blue_value, myImage);
                    setColour(3, 43 + a2, red_value, green_value, blue_value, myImage);
                    setColour(3, 45 + a2, red_value, green_value, blue_value, myImage);
                }

            }
        }
    }
}