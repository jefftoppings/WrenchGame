package jeff.game.wrenchgame;

public class Wrench {

    int x, y, speed;

    public Wrench(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 20;
    }

    public void moveWrench() {
        this.y += speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
