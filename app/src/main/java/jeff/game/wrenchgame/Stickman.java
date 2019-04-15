package jeff.game.wrenchgame;

public class Stickman {

    int x, y;
    private static final int STICKMAN_WIDTH = 100;

    public Stickman(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveLeft() {
        if (x > STICKMAN_WIDTH) {
            x -= 20;
        }
    }

    public void moveRight() {
        if (x < MainActivity.width - STICKMAN_WIDTH - 200) {
            x += 20;
        }
    }
}
