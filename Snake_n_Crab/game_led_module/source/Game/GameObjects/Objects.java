package Game.GameObjects;

public abstract class Objects {

   protected int ypos;
   protected int xpos;
   protected int red_value;
   protected int green_value;
   protected int blue_value;

   public Objects (int ypos, int xpos, int red_value, int green_value, int blue_value){
       this.ypos = ypos;
       this.xpos = xpos;
       this.red_value = red_value;
       this.green_value = green_value;
       this.blue_value = blue_value;
   }

    public int getYpos() {
        return ypos;
    }

    public int getXpos() {
        return xpos;
    }

    public int getRed_value() {
        return red_value;
    }

    public int getGreen_value() {
        return green_value;
    }

    public int getBlue_value() {
        return blue_value;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public void setRed_value(short red_value) { this.red_value = red_value; }

    public void setGreen_value(short green_value) {
        this.green_value = green_value;
    }

    public void setBlue_value(short blue_value) {
        this.blue_value = blue_value;
    }
}
