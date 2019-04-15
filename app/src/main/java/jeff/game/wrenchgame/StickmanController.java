package jeff.game.wrenchgame;

import android.view.MotionEvent;
import android.view.View;

public class StickmanController {

    GamePlay view;
    Model model;

    public StickmanController() {

    }

    public void setView(GamePlay view) {
        this.view = view;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public boolean handleTouch(View view, MotionEvent e) {

        // determine which way to move stickman
        int half = MainActivity.width / 2;

        if (e.getX() < half) {
            // move left
            model.stickman.moveLeft();
        }
        else {
            // move right
            model.stickman.moveRight();
        }

        view.invalidate();
        return false;
    }
}
