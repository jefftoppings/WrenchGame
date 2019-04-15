package jeff.game.wrenchgame;

import java.util.ArrayList;

public class Model {

    ArrayList<Wrench> wrenches;
    Stickman stickman;

    public Model() {
        wrenches = new ArrayList<>();
        stickman = new Stickman(MainActivity.width / 2, MainActivity.height - 800);
    }

    public void setStickman(Stickman stickman) {
        this.stickman = stickman;
    }
}
