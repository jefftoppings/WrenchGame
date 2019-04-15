package jeff.game.wrenchgame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

public class GamePlay extends View {

    Canvas canvas;
    Paint paint;
    Random random;
    int score;
    Model model;
    StickmanController controller;
    boolean gameOver;

    @SuppressLint("ClickableViewAccessibility")
    public GamePlay(Context context) {
        super(context);
        random = new Random();
        paint = new Paint();
        score = 0;
        model = new Model();
        controller = new StickmanController();
        controller.setModel(model);
        controller.setView(this);
        this.setOnTouchListener(controller::handleTouch);
        gameOver = false;
        setBackgroundColor(Color.rgb(237, 247, 210));

        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;

        displayScore(canvas);
        drawStickman(canvas);
    }

    private void drawStickman(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.stickman);
        canvas.drawBitmap(bitmap, model.stickman.x, model.stickman.y, paint);
    }

    private void displayScore(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setTextSize(60);
        canvas.drawText("Score: " + score, 60, 100, paint);
    }

}
