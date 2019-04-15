package jeff.game.wrenchgame;

public class Stickman {

    int x, y;

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
        x -= 20;
    }

    public void moveRight() {
        x += 20;
    }
}
