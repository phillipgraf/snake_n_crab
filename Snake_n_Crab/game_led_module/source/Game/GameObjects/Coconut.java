package Game.GameObjects;

import Game.GameObjects.Objects;

public class Coconut extends Objects {

    public Coconut(){
        super((int)(Math.random() * 22) + 1, (int)(Math.random() * 46) + 1, 150, 90, 62);
    }

}
