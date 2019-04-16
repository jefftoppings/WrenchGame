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

    public boolean collision() {
        int wrenchX1 = wrench.x;
        int wrenchX2 = (int) (wrench.x + (724 * 0.2));
        int stickmanX1 = stickman.x;
        int stickmanX2 = stickman.x + 78;

        if (wrench.y >= stickman.y) {
            if (wrenchX1 < stickmanX1) {
                if (stickmanX1 < wrenchX2 && wrenchX2 > stickmanX2) {
                    return true;
                }
            } else {
                if (wrenchX2 > stickmanX2) {
                    if (stickmanX1 < wrenchX1 && wrenchX1 < stickmanX2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
