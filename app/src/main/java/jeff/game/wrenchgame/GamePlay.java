package jeff.game.wrenchgame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;

import java.util.Random;

public class GamePlay extends View {

    Canvas canvas;
    Paint paint;
    Random random;
    int score, speed;
    Model model;
    StickmanController controller;
    boolean gameOver;
    Bitmap stickmanBitmap, wrenchBitmap;
    long startTime = -1;
    float mPxPerSecond;
    Matrix transform = new Matrix();

    @SuppressLint("ClickableViewAccessibility")
    public GamePlay(Context context) {
        super(context);
        random = new Random();
        paint = new Paint();
        score = 0;
        speed = 100;
        model = new Model();
        controller = new StickmanController();
        controller.setModel(model);
        controller.setView(this);
        this.setOnTouchListener(controller::handleTouch);
        stickmanBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.stickman);
        wrenchBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wrench1);
        wrenchBitmap = Bitmap.createScaledBitmap(wrenchBitmap,(int)(wrenchBitmap.getWidth()*0.2),
                (int)(wrenchBitmap.getHeight()*0.2), true);

        mPxPerSecond = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, speed,
                getResources().getDisplayMetrics());

        gameOver = false;
        setBackgroundColor(Color.rgb(237, 247, 210));

        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;

        displayScore(canvas);
        drawStickman(canvas);
        drawWrenches(canvas);
    }

    private void drawWrenches(Canvas canvas) {
        if (startTime == -1) {
            startTime = getDrawingTime();
        }
        long currentTime = getDrawingTime();
        float secondsPassed = (currentTime - startTime) / 1000f;

        float movedDistance = secondsPassed * mPxPerSecond;

        // determine if collision happened
        if (model.collision()) {
            MainActivity.root.removeAllViews();
            MainActivity.root.addView(new GameOver(getContext(), score));
            return;
        }

        if (movedDistance > MainActivity.height) {
            movedDistance = 0;
            startTime = -1;
            model.newWrench();

            // handle scoring
            score++;

            // speed up next wrench
            if (speed < 200) {
                speed *= 1.25;
                mPxPerSecond = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, speed,
                        getResources().getDisplayMetrics());
                wrenchBitmap.recycle();
                wrenchBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wrench1);
                wrenchBitmap = Bitmap.createScaledBitmap(wrenchBitmap,(int)(wrenchBitmap.getWidth()*0.2),
                        (int)(wrenchBitmap.getHeight()*0.2), true);
            }
        }

        transform.reset();
        model.wrench.y = (int) movedDistance;
        transform.postTranslate(model.wrench.x, model.wrench.y);

        canvas.drawBitmap(wrenchBitmap, transform, paint);

        invalidate();
    }

    private void drawStickman(Canvas canvas) {
        canvas.drawBitmap(stickmanBitmap, model.stickman.x, model.stickman.y, paint);
    }

    private void displayScore(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setTextSize(60);
        canvas.drawText("Score: " + score, 60, 100, paint);
    }

}
