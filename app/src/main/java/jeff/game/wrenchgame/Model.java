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

    public boolean collision() {
        int wrenchX1 = wrench.x;
        int wrenchX2 = (int) (wrench.x + (724 * 0.2));
        int wrenchHeight = 210;
        int stickmanX1 = stickman.x;
        int stickmanX2 = stickman.x + 78;
        int stickmanHeight = 156;

        if ((wrenchHeight + wrench.y >= stickman.y) &&
                (wrench.y <= stickman.y + stickmanHeight)) {
            if ((stickmanX1 <= wrenchX1 && wrenchX1 <= stickmanX2) ||
                    (stickmanX1 <= wrenchX2 && wrenchX2 <= stickmanX2) ||
                    (wrenchX1 <= stickmanX1 && stickmanX2 >= wrenchX2)) {
                return true;
            }
        }
        return false;
    }
}
