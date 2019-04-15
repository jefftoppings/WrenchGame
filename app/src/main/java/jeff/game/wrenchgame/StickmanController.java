package jeff.game.wrenchgame;

import android.view.MotionEvent;
import android.view.View;

public class StickmanController {

    GamePlay view;
    Model model;

    enum State {
        READY, MOVING_LEFT, MOVING_RIGHT
    }

    State state;

    public StickmanController() {
        state = State.READY;
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

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (e.getX() < half) {
                    model.stickman.moveLeft();
                    view.invalidate();
                }
                else {
                    model.stickman.moveRight();
                    view.invalidate();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (e.getX() < half) {
                    model.stickman.moveLeft();
                    view.invalidate();
                }
                else {
                    model.stickman.moveRight();
                    view.invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        view.invalidate();
        return true;
    }
}
