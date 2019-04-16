package jeff.game.wrenchgame;


import java.util.Random;

public class Model {

    Stickman stickman;
    Wrench wrench;
    Random random;

    public Model() {
        random = new Random();
        stickman = new Stickman(MainActivity.width / 2, MainActivity.height - 800);
        newWrench();
    }

    public void newWrench() {
        wrench = new Wrench(random.nextInt(MainActivity.width - 400), 0);
    }

    public void moveWrench() {
        wrench.moveWrench();
    }
}
